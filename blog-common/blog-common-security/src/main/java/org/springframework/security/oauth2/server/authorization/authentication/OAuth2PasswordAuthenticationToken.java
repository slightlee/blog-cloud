package org.springframework.security.oauth2.server.authorization.authentication;

import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.server.authorization.util.SpringAuthorizationServerVersion;
import org.springframework.util.Assert;

import java.io.Serial;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An {@link Authentication} implementation used for the OAuth 2 Password Grant.
 *
 * @author demain_lee
 * @since 0.0.1
 * @see OAuth2AuthorizationGrantAuthenticationToken
 * @see OAuth2PasswordAuthenticationProvider
 */
public class OAuth2PasswordAuthenticationToken extends OAuth2AuthorizationGrantAuthenticationToken {

	@Serial
	private static final long serialVersionUID = SpringAuthorizationServerVersion.SERIAL_VERSION_UID;

	private final String username;

	private final String password;

	private final Set<String> scopes;

	/**
	 * Constructs an {@code OAuth2PasswordAuthenticationToken} using the provided
	 * parameters.
	 * @param username the username
	 * @param password the password
	 * @param clientPrincipal the authenticated client principal
	 * @param scopes the requested scope(s)
	 * @param additionalParameters the additional parameters
	 */
	public OAuth2PasswordAuthenticationToken(String username, String password, Authentication clientPrincipal,
			@Nullable Set<String> scopes, @Nullable Map<String, Object> additionalParameters) {
		super(AuthorizationGrantType.PASSWORD, clientPrincipal, additionalParameters);
		Assert.hasText(username, "username cannot be empty");
		Assert.hasText(password, "password cannot be empty");
		this.username = username;
		this.password = password;
		this.scopes = Collections.unmodifiableSet(scopes != null ? new HashSet<>(scopes) : Collections.emptySet());
	}

	/**
	 * Returns the username.
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Returns the password.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Returns the requested scope(s).
	 * @return the requested scope(s)
	 */
	public Set<String> getScopes() {
		return scopes;
	}

}
