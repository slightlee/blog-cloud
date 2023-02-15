package org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.OAuth2Token;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2PasswordAuthenticationProvider;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenGenerator;

/**
 * An Builder for {@link OAuth2PasswordAuthenticationProviderBuilder}.
 *
 * @author demain_lee
 * @since 0.0.1
 * @see OAuth2PasswordAuthenticationProvider
 * @see OAuth2AuthorizationService
 * @see OAuth2TokenGenerator
 */
public class OAuth2PasswordAuthenticationProviderBuilder {

	private final HttpSecurity httpSecurity;

	private final UserDetailsService userDetailsService;

	private final PasswordEncoder passwordEncoder;

	public OAuth2PasswordAuthenticationProviderBuilder(HttpSecurity httpSecurity, UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) {
		this.httpSecurity = httpSecurity;
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	public OAuth2PasswordAuthenticationProvider build() {
		OAuth2AuthorizationService authorizationService = OAuth2ConfigurerUtils.getAuthorizationService(httpSecurity);
		OAuth2TokenGenerator<? extends OAuth2Token> tokenGenerator = OAuth2ConfigurerUtils
				.getTokenGenerator(httpSecurity);

		return new OAuth2PasswordAuthenticationProvider(authorizationService, tokenGenerator, userDetailsService,
				passwordEncoder);

	}

}
