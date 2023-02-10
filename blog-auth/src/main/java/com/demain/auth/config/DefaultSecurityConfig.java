package com.demain.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 默认配置
 *
 * @author demain_lee
 * @since 0.0.1
 */
@EnableWebSecurity
@Configuration(proxyBeanMethods = false)
public class DefaultSecurityConfig {

	/**
	 * Spring Security的过滤器链，用于Spring Security的身份认证。
	 */
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http.
			authorizeHttpRequests(authorize ->
				authorize.anyRequest().authenticated()
			)
			.formLogin(Customizer.withDefaults()
		);
		// @formatter:on
		return http.build();
	}

	/**
	 * 密码编码器
	 */
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
