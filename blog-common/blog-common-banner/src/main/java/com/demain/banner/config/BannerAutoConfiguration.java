package com.demain.banner.config;

import com.demain.banner.core.BannerApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Banner 自动配置
 *
 * @author demain_lee
 * @since 0.0.1
 */
@AutoConfiguration
public class BannerAutoConfiguration {

	@Bean
	public BannerApplicationRunner bannerApplicationRunner() {
		return new BannerApplicationRunner();
	}

}
