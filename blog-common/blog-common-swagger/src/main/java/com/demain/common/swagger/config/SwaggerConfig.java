package com.demain.common.swagger.config;

import com.demain.common.swagger.properties.SwaggerProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger 配置
 *
 * @author demain_lee
 * @since 0.0.1
 */
@ConditionalOnProperty(name = "swagger.enabled", havingValue = "true")
public class SwaggerConfig {

	private final SwaggerProperties swaggerProperties;

	private final ServiceInstance serviceInstance;

	public SwaggerConfig(SwaggerProperties swaggerProperties, ServiceInstance serviceInstance) {
		this.swaggerProperties = swaggerProperties;
		this.serviceInstance = serviceInstance;
	}

	@Bean
	public OpenAPI openApi() {
		List<Server> serverList = new ArrayList<>();
		/*
		 * swaggerProperties.getServices 是一个 Map，key 是服务名，value 是服务的 context-path 示例：
		 * blog-user: blog-user 可使用方式获取: [ serverList.add(new
		 * Server().url(swaggerProperties.getGateway() + "/"+
		 * swaggerProperties.getServices().get(serviceInstance.getServiceId()))); ] 此处
		 * swaggerProperties.getServices 使用 示例： blog-user: 用户服务 ，直接使用
		 * serviceInstance.getServiceId() 获取服务名
		 */
		serverList.add(new Server().url(swaggerProperties.getGateway() + "/" + serviceInstance.getServiceId()));
		return new OpenAPI().info(new Info().title(swaggerProperties.getTitle()).version(swaggerProperties.getVersion())
				.contact(new Contact().email(swaggerProperties.getContact().getEmail())
						.name(swaggerProperties.getContact().getName()).url(swaggerProperties.getContact().getUrl()))
				.description(swaggerProperties.getDescription())
				.termsOfService(swaggerProperties.getTermsOfServiceUrl())
				.license(new License().name(swaggerProperties.getLicense().getName())
						.url(swaggerProperties.getLicense().getUrl())
						.identifier(swaggerProperties.getLicense().getIdentifier())))
				.servers(serverList);
	}

}
