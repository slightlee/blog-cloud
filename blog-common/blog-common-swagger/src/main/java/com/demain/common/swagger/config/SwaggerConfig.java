package com.demain.common.swagger.config;

import com.demain.common.swagger.properties.SwaggerProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * swagger 配置
 *
 * @author demain_lee
 * @since 0.0.1
 */
@ConditionalOnProperty(name = "swagger.enabled", havingValue = "true")
public class SwaggerConfig {

	private final SwaggerProperties swaggerProperties;

	public SwaggerConfig(SwaggerProperties swaggerProperties) {
		this.swaggerProperties = swaggerProperties;
	}

	@Bean
	public OpenAPI openApi() {
		return new OpenAPI().info(new Info().title(swaggerProperties.getTitle()).version(swaggerProperties.getVersion())
				.contact(new Contact().email(swaggerProperties.getContact().getEmail())
						.name(swaggerProperties.getContact().getName()).url(swaggerProperties.getContact().getUrl()))
				.description(swaggerProperties.getDescription())
				.termsOfService(swaggerProperties.getTermsOfServiceUrl())
				.license(new License().name(swaggerProperties.getLicense().getName())
						.url(swaggerProperties.getLicense().getUrl())
						.identifier(swaggerProperties.getLicense().getIdentifier())));
	}

}
