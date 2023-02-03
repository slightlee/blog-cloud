package com.demain.common.core.config;

import com.demain.common.core.handler.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义配置
 *
 * @author demain_lee
 * @since 0.0.1
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * 添加自定义拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ResponseResultInterceptor()).addPathPatterns("/**");
	}

}
