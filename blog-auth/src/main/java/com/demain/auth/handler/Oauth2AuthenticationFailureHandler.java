package com.demain.auth.handler;

import com.demain.common.core.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义失败响应处理器
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class Oauth2AuthenticationFailureHandler implements AuthenticationFailureHandler {

	private static final Logger log = LoggerFactory.getLogger(Oauth2AuthenticationFailureHandler.class);

	private final MappingJackson2HttpMessageConverter errorHttpResponseConverter = new MappingJackson2HttpMessageConverter();


	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String username = request.getParameter(OAuth2ParameterNames.USERNAME);

		log.info("用户：{} 登录失败，异常：{}", username, exception.getLocalizedMessage());

		if (exception instanceof OAuth2AuthenticationException) {
			OAuth2AuthenticationException authorizationException = (OAuth2AuthenticationException) exception;
			System.out.println(authorizationException.getError().getErrorCode());
		}

		ServletServerHttpResponse httpResponse = new ServletServerHttpResponse(response);
		OAuth2AuthenticationException authorizationException = (OAuth2AuthenticationException) exception;
		this.errorHttpResponseConverter.write(Result.error(authorizationException.getError().getErrorCode(),authorizationException.getError().getDescription()), MediaType.APPLICATION_JSON, httpResponse);
	}

}
