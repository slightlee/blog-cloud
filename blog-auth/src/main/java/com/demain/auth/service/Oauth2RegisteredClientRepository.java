package com.demain.auth.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.demain.auth.entity.Oauth2ClientSettings;
import com.demain.auth.entity.Oauth2RegisteredClient;
import com.demain.auth.entity.Oauth2TokenSettings;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 数据库实现 客户端信息
 *
 * @author demain_lee
 * @since 0.0.1
 */
@Service
public class Oauth2RegisteredClientRepository implements RegisteredClientRepository {

	private final Oauth2RegisteredClientService oauth2RegisteredClientService;

	private final Oauth2ClientSettingsService oauth2ClientSettingsService;

	private final Oauth2TokenSettingsService oauth2TokenSettingsService;

	public Oauth2RegisteredClientRepository(Oauth2RegisteredClientService oauth2RegisteredClientService,
											Oauth2ClientSettingsService oauth2ClientSettingsService,
											Oauth2TokenSettingsService oauth2TokenSettingsService) {
		this.oauth2RegisteredClientService = oauth2RegisteredClientService;
		this.oauth2ClientSettingsService = oauth2ClientSettingsService;
		this.oauth2TokenSettingsService = oauth2TokenSettingsService;
	}

	@Override
	public void save(RegisteredClient registeredClient) {
		// TODO
	}

	@Override
	public RegisteredClient findById(String id) {
		// TODO
		return null;
	}

	@Override
	public RegisteredClient findByClientId(String clientId) {
		Oauth2RegisteredClient oauth2RegisteredClient = oauth2RegisteredClientService.getOne(
				Wrappers.<Oauth2RegisteredClient>lambdaQuery().eq(Oauth2RegisteredClient::getClientId, clientId));

		String clientAuthenticationMethods = oauth2RegisteredClient.getClientAuthenticationMethods();
		String authorizationGrantTypes = oauth2RegisteredClient.getAuthorizationGrantTypes();
		String scopes = oauth2RegisteredClient.getScopes();
		String redirectUris = oauth2RegisteredClient.getRedirectUris();
		List<String> clientAuthenticationMethodsList = Arrays.asList(clientAuthenticationMethods.split(","));
		List<String> authorizationGrantTypeList = Arrays.asList(authorizationGrantTypes.split(","));
		Set<ClientAuthenticationMethod> clientAuthenticationMethodSet = new HashSet<>();
		Set<AuthorizationGrantType> authorizationGrantTypeSet = new HashSet<>();
		authorizationGrantTypeList.forEach(s -> authorizationGrantTypeSet.add(new AuthorizationGrantType(s)));
		clientAuthenticationMethodsList
				.forEach(s -> clientAuthenticationMethodSet.add(new ClientAuthenticationMethod(s)));

		Oauth2ClientSettings oauth2ClientSettings = oauth2ClientSettingsService.getOne(
				Wrappers.<Oauth2ClientSettings>lambdaQuery().eq(Oauth2ClientSettings::getRegisteredClientId, oauth2RegisteredClient.getId()));

		Oauth2TokenSettings oauth2TokenSettings = oauth2TokenSettingsService.getOne(
				Wrappers.<Oauth2TokenSettings>lambdaQuery().eq(Oauth2TokenSettings::getRegisteredClientId, oauth2RegisteredClient.getId()));

		RegisteredClient registeredClient = RegisteredClient.withId(oauth2RegisteredClient.getId())
				.clientId(oauth2RegisteredClient.getClientId()).clientSecret(oauth2RegisteredClient.getClientSecret())
				.clientAuthenticationMethods(c -> c.addAll(clientAuthenticationMethodSet))
				.authorizationGrantTypes(a -> a.addAll(authorizationGrantTypeSet))
				.redirectUris(s -> s.addAll(Arrays.asList(redirectUris.split(","))))
				.scopes(s -> s.addAll(Arrays.asList(scopes.split(","))))
				.clientSettings(ClientSettings.builder()
						.requireProofKey(oauth2ClientSettings.getRequireProofKey())
						.jwkSetUrl(Optional.ofNullable(oauth2ClientSettings.getJwkSetUrl()).orElse(""))
						.requireAuthorizationConsent(oauth2ClientSettings.getRequireAuthorizationConsent())
						.tokenEndpointAuthenticationSigningAlgorithm(
								oauth2ClientSettings::getTokenEndpointAuthenticationSigningAlgorithm)
						.build())
				.tokenSettings(TokenSettings.builder()
						.authorizationCodeTimeToLive(oauth2TokenSettings.getAuthorizationCodeTimeToLive())
						.accessTokenTimeToLive(oauth2TokenSettings.getAccessTokenTimeToLive())
						.accessTokenFormat(new OAuth2TokenFormat(oauth2TokenSettings.getAccessTokenFormat()))
						.reuseRefreshTokens(oauth2TokenSettings.getReuseRefreshTokens())
						.refreshTokenTimeToLive(oauth2TokenSettings.getRefreshTokenTimeToLive())
						.idTokenSignatureAlgorithm(
								SignatureAlgorithm.from(oauth2TokenSettings.getIdTokenSignatureAlgorithm()))
						.build())
				.build();
		return registeredClient;
	}

}
