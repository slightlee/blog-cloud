package com.demain.banner.core;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.TimeUnit;

/**
 * 项目启动成功，控制台输出相关地址
 *
 * @author demain_lee
 * @since 0.0.1
 */
@Slf4j
public class BannerApplicationRunner implements ApplicationRunner {

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${server.port}")
	private String port;

	@Override
	public void run(ApplicationArguments args) {

		ThreadUtil.execute(() -> {
			ThreadUtil.sleep(1, TimeUnit.SECONDS); // 延迟 1 秒，保证输出到结尾
			log.info("""

					==========================================================
					\t {} 服务启动成功 φ(゜▽゜*)♪
					\t 占用端口: \t{}\s
					\t 接口文档: \t{}\s
					==========================================================""", applicationName, port,
					"http://127.0.0.1:port/doc.html");
		});
	}

}
