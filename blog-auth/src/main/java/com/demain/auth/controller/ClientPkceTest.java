package com.demain.auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.authorization.authentication.ClientSecretAuthenticationProvider;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * 授权码+PKCE流程测试
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class ClientPkceTest {

	public static void main(String[] args) throws Exception {
		// 明文 (实际应用中，这个最好设置为随机字符串)
		String code_verifier = "cloud123456";
		// 摘要算法
		String code_challenge_method = "SHA-256";
		// 密文
		String code_challenge = calc(code_verifier, code_challenge_method);
		// 输出的密文：VN4QwBM9xoD3M8ENFwW2EU1qg8AfmtpskQZRIPutM_U
		System.out.println(code_challenge);
	}

	/**
	 * 明文 + 摘要算法，生成 密文
	 * @see org.springframework.security.oauth2.server.authorization.authentication.CodeVerifierAuthenticator#codeVerifierValid(java.lang.String,
	 * java.lang.String, java.lang.String) 核心逻辑 入口：
	 * @see ClientSecretAuthenticationProvider#authenticate(Authentication) 下 Validate the
	 * "code_verifier" parameter for the confidential client, if available
	 * @see CodeVerifierAuthenticator#authenticate(OAuth2ClientAuthenticationToken,
	 * RegisteredClient)
	 * @see CodeVerifierAuthenticator#codeVerifierValid(String, String, String)
	 */
	private static String calc(String code_verifier, String code_challenge_method) throws Exception {
		byte[] bytes = code_verifier.getBytes(StandardCharsets.US_ASCII);
		MessageDigest md = MessageDigest.getInstance(code_challenge_method);
		byte[] digest = md.digest(bytes);
		String code_challenge = Base64.getUrlEncoder().withoutPadding().encodeToString(digest);
		return code_challenge;
	}

}
