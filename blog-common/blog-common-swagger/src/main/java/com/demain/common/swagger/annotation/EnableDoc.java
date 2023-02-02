package com.demain.common.swagger.annotation;

import com.demain.common.swagger.config.SwaggerConfig;
import com.demain.common.swagger.properties.SwaggerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启 doc 文档
 * @author demain_lee
 * @since 0.0.1
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableConfigurationProperties(SwaggerProperties.class)
@Import({ SwaggerConfig.class })
public @interface EnableDoc {

}
