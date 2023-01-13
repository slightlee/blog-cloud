package com.demain.gateway.config;

import lombok.Data;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 文档配置
 *
 * @author demain_lee
 * @since 0.0.1
 */
@Configuration(proxyBeanMethods = false)
public class SpringDocConfiguration {

	@Bean
	@Lazy(false)
	@ConditionalOnProperty(name = "springdoc.api-docs.enabled", matchIfMissing = true)
	public List<GroupedOpenApi> apis(SwaggerUiConfigParameters swaggerUiConfigParameters,
			SwaggerDocProperties swaggerProperties) {
		List<GroupedOpenApi> groups = new ArrayList<>();
		// for (String value : swaggerProperties.getServices().values()) {
		// swaggerUiConfigParameters.addGroup(value);
		// }
		swaggerUiConfigParameters.addGroup("blog-user", "用户服务");
		swaggerUiConfigParameters.addGroup("blog-content", "内容服务");
		return groups;
	}

	// @Bean
	// @Lazy(false)
	// @ConditionalOnProperty(prefix = "swagger", name = "enabled", havingValue = "true")
	// public List<GroupedOpenApi> apis(RouteDefinitionLocator locator) {
	// List<GroupedOpenApi> groups = new ArrayList<>();
	// List<RouteDefinition> definitions =
	// locator.getRouteDefinitions().collectList().block();
	// assert definitions != null;
	// for (RouteDefinition definition : definitions) {
	// System.out.println("id: " + definition.getId() + " " +
	// definition.getUri().toString());
	// }
	// definitions.stream().filter(routeDefinition ->
	// routeDefinition.getId().matches("blog-.*"))
	// .forEach(routeDefinition -> {
	// String name = routeDefinition.getId();
	// GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
	// });
	// return groups;
	// }

	@Data
	@Component
	@ConfigurationProperties("swagger")
	public static class SwaggerDocProperties {

		private Map<String, String> services;

	}

}
