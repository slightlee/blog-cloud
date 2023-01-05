package com.demain.mybatis.config;

import com.demain.mybatis.core.handler.MySqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 *
 * @author demain_lee
 * @since 0.0.1
 */
@Configuration
public class MybatisPlusConfig {

	/**
	 * 自定义 SqlInjector 里面包含自定义的全局方法
	 */
	@Bean
	public MySqlInjector myLogicSqlInjector() {
		return new MySqlInjector();
	}

}
