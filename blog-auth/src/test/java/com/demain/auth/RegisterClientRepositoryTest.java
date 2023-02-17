package com.demain.auth;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.demain.auth.entity.Oauth2ClientSettings;
import com.demain.auth.entity.Oauth2RegisteredClient;
import com.demain.auth.entity.Oauth2TokenSettings;
import com.demain.auth.service.Oauth2ClientSettingsService;
import com.demain.auth.service.Oauth2RegisteredClientService;
import com.demain.auth.service.Oauth2TokenSettingsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;
import java.util.Set;
import java.util.UUID;

@SpringBootTest
public class RegisterClientRepositoryTest {

	@Autowired
	private Oauth2RegisteredClientService oauth2RegisteredClientService;

	@Autowired
	private Oauth2ClientSettingsService oauth2ClientSettingsService;

	@Autowired
	private Oauth2TokenSettingsService oauth2TokenSettingsService;

	/**
	 * 授权码模式 保存客户端
	 */
	@Test
	public void authorizationCodeSave() {

		// @formatter:off
		TokenSettings tokenSettings = TokenSettings.builder()
				// 系统默认配置
				.authorizationCodeTimeToLive(Duration.ofMinutes(5))
				.accessTokenTimeToLive(Duration.ofMinutes(5))
				.accessTokenFormat(OAuth2TokenFormat.SELF_CONTAINED)
				.reuseRefreshTokens(true)
				.refreshTokenTimeToLive(Duration.ofMinutes(60))
				.idTokenSignatureAlgorithm(SignatureAlgorithm.RS256)
				.build();

		RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
				.clientId("blog-client")
				.clientSecret(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("blog-secret"))
				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
				.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
				.authorizationGrantType(AuthorizationGrantType.PASSWORD)
				.redirectUri("http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc")
				.redirectUri("http://127.0.0.1:8080/authorized").scope(OidcScopes.OPENID).scope(OidcScopes.PROFILE)
				.scope("message.read").scope("message.write")
				// 系统默认设置
				// .clientSettings(clientSettings)
				.tokenSettings(tokenSettings).build();

		Set<ClientAuthenticationMethod> clientAuthenticationMethods = registeredClient.getClientAuthenticationMethods();
		Set<AuthorizationGrantType> authorizationGrantTypes = registeredClient.getAuthorizationGrantTypes();
		Set<String> redirectUris = registeredClient.getRedirectUris();
		Set<String> scopes = registeredClient.getScopes();
		String clientAuthenticationMethodsStr = String.join(",",
				clientAuthenticationMethods.stream().map(ClientAuthenticationMethod::getValue).toArray(String[]::new));
		String authorizationGrantTypesStr = String.join(",",
				authorizationGrantTypes.stream().map(AuthorizationGrantType::getValue).toArray(String[]::new));
		String redirectUrisStr = String.join(",", redirectUris.toArray(String[]::new));
		String scopesStr = String.join(",", scopes.toArray(String[]::new));

		Oauth2RegisteredClient oauth2RegisteredClient = Oauth2RegisteredClient.builder()
				.clientId(registeredClient.getClientId())
				.clientSecret(registeredClient.getClientSecret())
				.clientName(registeredClient.getClientId())
				.clientAuthenticationMethods(clientAuthenticationMethodsStr)
				.authorizationGrantTypes(authorizationGrantTypesStr)
				.redirectUris(redirectUrisStr).scopes(scopesStr)
				.build();
		oauth2RegisteredClientService.save(oauth2RegisteredClient);

		Oauth2ClientSettings oauth2ClientSettings = Oauth2ClientSettings.builder()
				.registeredClientId(oauth2RegisteredClient.getId())
				.requireProofKey(registeredClient.getClientSettings().isRequireProofKey())
				.requireAuthorizationConsent(registeredClient.getClientSettings().isRequireAuthorizationConsent())
				.build();
		oauth2ClientSettingsService.save(oauth2ClientSettings);

		Oauth2TokenSettings oauth2TokenSettings = Oauth2TokenSettings.builder()
				.registeredClientId(oauth2RegisteredClient.getId())
				.authorizationCodeTimeToLive(registeredClient.getTokenSettings().getAuthorizationCodeTimeToLive())
				.accessTokenTimeToLive(registeredClient.getTokenSettings().getAccessTokenTimeToLive())
				.accessTokenFormat(registeredClient.getTokenSettings().getAccessTokenFormat().getValue())
				.reuseRefreshTokens(registeredClient.getTokenSettings().isReuseRefreshTokens())
				.refreshTokenTimeToLive(registeredClient.getTokenSettings().getRefreshTokenTimeToLive())
				.idTokenSignatureAlgorithm(registeredClient.getTokenSettings().getIdTokenSignatureAlgorithm().getName())
				.build();
		oauth2TokenSettingsService.save(oauth2TokenSettings);
		// @formatter:on

	}

	/**
	 * 授权码模式+PKCE 保存客户端
	 */
	@Test
	public void authorizationCodeAndPKCESave() {

		// @formatter:off
		TokenSettings tokenSettings = TokenSettings.builder()
				// 系统默认配置
				.authorizationCodeTimeToLive(Duration.ofMinutes(5))
				.accessTokenTimeToLive(Duration.ofMinutes(5))
				.accessTokenFormat(OAuth2TokenFormat.SELF_CONTAINED)
				.reuseRefreshTokens(true)
				.refreshTokenTimeToLive(Duration.ofMinutes(60))
				.idTokenSignatureAlgorithm(SignatureAlgorithm.RS256)
				.build();

//		授权码+PKCE流程测试
		RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
				.clientId("blog-client-pkce")
//				.clientSecret("$2a$10$WYfhJgvqO/mX0On.rVaQcO72d4gZ64RVQnQWIMWFeROTcwVaZNQXy")
				.clientAuthenticationMethod(ClientAuthenticationMethod.NONE)
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.redirectUri("http://127.0.0.1:8080/authorized")
				.scope("message.read")
				.clientSettings(ClientSettings.builder()
						// 公共客户端（NONE方式认证）必须开启 PKCE 流程
						.requireProofKey(true)
						// 授权码模式需要用户手动授权！false表示默认通过
						.requireAuthorizationConsent(true)
						.build())
				.tokenSettings(tokenSettings)
				.build();

		Set<ClientAuthenticationMethod> clientAuthenticationMethods = registeredClient.getClientAuthenticationMethods();
		Set<AuthorizationGrantType> authorizationGrantTypes = registeredClient.getAuthorizationGrantTypes();
		Set<String> redirectUris = registeredClient.getRedirectUris();
		Set<String> scopes = registeredClient.getScopes();
		String clientAuthenticationMethodsStr = String.join(",",
				clientAuthenticationMethods.stream().map(ClientAuthenticationMethod::getValue).toArray(String[]::new));
		String authorizationGrantTypesStr = String.join(",",
				authorizationGrantTypes.stream().map(AuthorizationGrantType::getValue).toArray(String[]::new));
		String redirectUrisStr = String.join(",", redirectUris.toArray(String[]::new));
		String scopesStr = String.join(",", scopes.toArray(String[]::new));

		Oauth2RegisteredClient oauth2RegisteredClient = Oauth2RegisteredClient.builder()
				.clientId(registeredClient.getClientId())
				.clientSecret(registeredClient.getClientSecret())
				.clientName(registeredClient.getClientId())
				.clientAuthenticationMethods(clientAuthenticationMethodsStr)
				.authorizationGrantTypes(authorizationGrantTypesStr)
				.redirectUris(redirectUrisStr).scopes(scopesStr)
				.build();
		oauth2RegisteredClientService.save(oauth2RegisteredClient);

		Oauth2ClientSettings oauth2ClientSettings = Oauth2ClientSettings.builder()
				.registeredClientId(oauth2RegisteredClient.getId())
				.requireProofKey(registeredClient.getClientSettings().isRequireProofKey())
				.requireAuthorizationConsent(registeredClient.getClientSettings().isRequireAuthorizationConsent())
				.build();
		oauth2ClientSettingsService.save(oauth2ClientSettings);

		Oauth2TokenSettings oauth2TokenSettings = Oauth2TokenSettings.builder()
				.registeredClientId(oauth2RegisteredClient.getId())
				.authorizationCodeTimeToLive(registeredClient.getTokenSettings().getAuthorizationCodeTimeToLive())
				.accessTokenTimeToLive(registeredClient.getTokenSettings().getAccessTokenTimeToLive())
				.accessTokenFormat(registeredClient.getTokenSettings().getAccessTokenFormat().getValue())
				.reuseRefreshTokens(registeredClient.getTokenSettings().isReuseRefreshTokens())
				.refreshTokenTimeToLive(registeredClient.getTokenSettings().getRefreshTokenTimeToLive())
				.idTokenSignatureAlgorithm(registeredClient.getTokenSettings().getIdTokenSignatureAlgorithm().getName())
				.build();
		oauth2TokenSettingsService.save(oauth2TokenSettings);
		// @formatter:on

	}

	@Test
	public void get() {
		Oauth2TokenSettings oauth2TokenSettings = oauth2TokenSettingsService
				.getOne(Wrappers.<Oauth2TokenSettings>lambdaQuery().eq(Oauth2TokenSettings::getRegisteredClientId,
						1626452475148509185L));
		System.out.println(oauth2TokenSettings.toString());
	}

}
