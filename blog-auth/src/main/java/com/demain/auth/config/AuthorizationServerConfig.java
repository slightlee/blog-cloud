package com.demain.auth.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Duration;
import java.util.UUID;

/**
 * 配置
 *
 * @author demain_lee
 * @since 0.0.1
 */
@Configuration(proxyBeanMethods = false)
public class AuthorizationServerConfig {

	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
		OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
		http.getConfigurer(OAuth2AuthorizationServerConfigurer.class)
				// Enable OpenID Connect 1.0
				.oidc(Customizer.withDefaults());
		// @formatter:off
		http
			.exceptionHandling(exceptions ->
				exceptions.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
			)
			.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
		// @formatter:on
		return http.build();
	}

	// @Bean
	// @Order(Ordered.HIGHEST_PRECEDENCE)
	// public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity
	// http) throws Exception {
	// OAuth2AuthorizationServerConfigurer authorizationServerConfigurer = new
	// OAuth2AuthorizationServerConfigurer();
	// RequestMatcher endpointsMatcher =
	// authorizationServerConfigurer.getEndpointsMatcher();
//		// @formatter:off
//		http
//			.requestMatcher(endpointsMatcher)
//			.authorizeRequests(authorizeRequests ->
//				authorizeRequests.anyRequest().authenticated()
//			)
//			.csrf(csrf ->
//				csrf.ignoringRequestMatchers(endpointsMatcher)
//			)
////			.exceptionHandling(exceptions ->
////				exceptions.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
////			)
////			.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//			.apply(authorizationServerConfigurer)
//			.and()
//			.formLogin()
//		;
//		// @formatter:on
	// return http.build();
	// }

	/**
	 * RegisteredClientRepository 主要用于管理第三方应用的信息 授权码模式： <a href=
	 * "http://127.0.0.1:8003/oauth2/authorize?response_type=code&client_id=blog-client&scope=message.read&redirect_uri=http://127.0.0.1:8080/authorized">...</a>
	 * 对应 oauth2_registered_client 表
	 */
	@Bean
	public RegisteredClientRepository registeredClientRepository() {
		// @formatter:off
		// 自定义 token 配置
		TokenSettings tokenSettings = TokenSettings.builder()
				.accessTokenTimeToLive(Duration.ofDays(1))
				.refreshTokenTimeToLive(Duration.ofDays(1))
				.reuseRefreshTokens(true)
				.build();
		RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
				.clientId("blog-client").clientSecret("{noop}blog-cloud")
				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
				.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
				.redirectUri("http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc")
				.redirectUri("http://127.0.0.1:8080/authorized")
				.scope(OidcScopes.OPENID)
				.scope(OidcScopes.PROFILE)
				.scope("message.read")
				.scope("message.write")
				.clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
				.tokenSettings(tokenSettings)
				.build();
		// @formatter:on

		return new InMemoryRegisteredClientRepository(registeredClient);
	}

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
