package com.demain.auth.config;

import com.demain.auth.handler.Oauth2AuthenticationFailureHandler;
import com.demain.auth.handler.Oauth2AuthenticationSuccessHandler;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2PasswordAuthenticationProviderBuilder;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.web.authentication.OAuth2PasswordAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

/**
 * 配置
 *
 * @author demain_lee
 * @since 0.0.1
 */
@Configuration(proxyBeanMethods = false)
public class AuthorizationServerConfig {

	private final UserDetailsService userDetailsService;

	private final PasswordEncoder passwordEncoder;

	public AuthorizationServerConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	// @Bean
	// @Order(Ordered.HIGHEST_PRECEDENCE)
	// public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity
	// http) throws Exception {
	// OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
//		// @formatter:off
//		http.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
//				// Enable OpenID Connect 1.0
//				.oidc(Customizer.withDefaults())
//				.tokenEndpoint(oAuth2TokenEndpointConfigurer ->
//						oAuth2TokenEndpointConfigurer
//							.authenticationProvider(new OAuth2PasswordAuthenticationProviderBuilder(http,userDetailsService,passwordEncoder).build())
//							.accessTokenRequestConverter(new OAuth2PasswordAuthenticationConverter())
//				);
//		http
//			.exceptionHandling(exceptions ->
//				exceptions.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
//			)
//			.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
//		// @formatter:on
	// return http.build();
	// }

	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
		OAuth2AuthorizationServerConfigurer authorizationServerConfigurer = new OAuth2AuthorizationServerConfigurer();
		RequestMatcher endpointsMatcher = authorizationServerConfigurer.getEndpointsMatcher();

		// @formatter:off
		authorizationServerConfigurer
			.tokenEndpoint(tokenEndpoint ->
				tokenEndpoint
					.authenticationProviders(authenticationProviders -> {
						authenticationProviders.add(new OAuth2PasswordAuthenticationProviderBuilder(http, userDetailsService, passwordEncoder).build());
					})
					.accessTokenRequestConverters(authenticationConverters -> {
						authenticationConverters.add(new OAuth2PasswordAuthenticationConverter());
					})
					// 成功响应处理器
					.accessTokenResponseHandler(new Oauth2AuthenticationSuccessHandler())
					// 登录失败处理器
					.errorResponseHandler(new Oauth2AuthenticationFailureHandler())
			);

		http
			.requestMatcher(endpointsMatcher)
			.authorizeRequests(authorizeRequests ->
					authorizeRequests.anyRequest().authenticated()
			)
			.csrf(csrf ->
					csrf.ignoringRequestMatchers(endpointsMatcher)
			)
			.exceptionHandling(exceptions ->
					exceptions.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
			)
			.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
			.apply(authorizationServerConfigurer)
//			.and()
//			.formLogin()
		;
		// @formatter:on
		return http.build();
	}

	// @formatter:off
	/*
	 * RegisteredClientRepository 主要用于管理第三方应用的信息 授权码模式：
	 * {@code http://127.0.0.1:8003/oauth2/authorize?response_type=code&client_id=blog-client&scope=message.read&redirect_uri=http://127.0.0.1:8080/authorized }
	 * {@code http://127.0.0.1:8003/oauth2/authorize?response_type=code&client_id=blog-client-pkce&scope=message.read&redirect_uri=http://127.0.0.1:8080/authorized&code_challenge=VN4QwBM9xoD3M8ENFwW2EU1qg8AfmtpskQZRIPutM_U&code_challenge_method=S256 }
	 * 对应 oauth2_registered_client 表
	 */
	// @formatter:on

	/**
	 * 用于签署访问令牌的实例
	 */
	@Bean
	public JWKSource<SecurityContext> jwkSource() {
		KeyPair keyPair = generateRsaKey();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		// @formatter:off
		RSAKey rsaKey = new RSAKey.Builder(publicKey)
				.privateKey(privateKey)
				.keyID(UUID.randomUUID().toString())
				.build();
		// @formatter:on
		JWKSet jwkSet = new JWKSet(rsaKey);

		return new ImmutableJWKSet<>(jwkSet);
	}

	/**
	 * 生成带密钥的实例 java.security.KeyPair
	 */
	public static KeyPair generateRsaKey() {
		KeyPair keyPair;
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);
			keyPair = keyPairGenerator.generateKeyPair();
		}
		catch (Exception ex) {
			throw new IllegalStateException(ex);
		}
		return keyPair;
	}

	/**
	 * 解码签名
	 * @param jwkSource jwkSource
	 * @return JwtDecoder
	 */
	@Bean
	public JwtDecoder jwtDecoder(JWKSource<SecurityContext> jwkSource) {
		return OAuth2AuthorizationServerConfiguration.jwtDecoder(jwkSource);
	}

	@Bean
	public AuthorizationServerSettings authorizationServerSettings() {
		return AuthorizationServerSettings.builder().build();
	}

}
