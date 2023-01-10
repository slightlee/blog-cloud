package com.demain.banner.core;

import cn.hutool.core.thread.ThreadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.concurrent.TimeUnit;

/**
 * 项目启动成功，控制台输出相关地址
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class BannerApplicationRunner implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(BannerApplicationRunner.class);

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${server.port}")
	private String port;

	@Override
	public void run(ApplicationArguments args) {

		ThreadUtil.execute(() -> {
			ThreadUtil.sleep(1, TimeUnit.SECONDS); // 延迟 1 秒，保证输出到结尾
			logger.info("""

					==========================================================
					\t {} 服务启动成功 φ(゜▽゜*)♪
					\t 占用端口: \t{}\s
					\t 接口文档: \t{}\s
					==========================================================""", applicationName, port,
					"http://127.0.0.1:8000/doc.html");
		});
	}

}
