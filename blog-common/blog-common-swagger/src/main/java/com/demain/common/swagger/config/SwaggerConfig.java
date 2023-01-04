package com.demain.common.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * swagger 配置
 *
 * @author demain_lee
 * @since 0.0.1
 */
@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi userApi() {
		String[] paths = { "/**" };
		String[] packagedToMatch = { "com.demain.user" };
		return GroupedOpenApi.builder().group("用户模块").pathsToMatch(paths).packagesToScan(packagedToMatch).build();
	}

	@Bean
	public GroupedOpenApi contentApi() {
		String[] paths = { "/**" };
		String[] packagedToMatch = { "com.demain.content" };
		return GroupedOpenApi.builder().group("内容模块").pathsToMatch(paths).packagesToScan(packagedToMatch).build();
	}

	@Bean
	public OpenAPI openApi() {
		return new OpenAPI().info(new Info().title("blog-cloud API").version("0.0.1").description("blog-cloud接口文档")
				.termsOfService("https://www.xxxx.com")
				.license(new License().name("Apache 2.0").url("https://www.xxx.com")));
	}

}
