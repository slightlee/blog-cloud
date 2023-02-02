package com.demain.banner.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * 项目启动成功，控制台输出相关信息 和 BannerApplicationRunner 二选一
 *
 * @author demain_lee
 * @since 0.0.1
 */
@Configuration
public class StartEventListener {

	private static final Logger log = LoggerFactory.getLogger(StartEventListener.class);

	public StartEventListener() {
	}

	/**
	 * WebServerInitializedEvent Web服务器初始化事件 在WebServer启动之后发送
	 */
	@Async
	@Order
	@EventListener({ WebServerInitializedEvent.class })
	public void afterStart(WebServerInitializedEvent event) {
		Environment environment = event.getApplicationContext().getEnvironment();
		String appName = Objects.requireNonNull(environment.getProperty("spring.application.name")).toUpperCase();
		int localPort = event.getWebServer().getPort();
		String profile = StringUtils.arrayToCommaDelimitedString(environment.getActiveProfiles());
		log.info("{} 服务启动成功，当前使用的端口: {}，环境变量: {}", appName, localPort, profile);
	}

}
