package com.demain.content;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 内容服务
 *
 * @author demain_lee
 * @since 0.0.1
 */
@SpringBootApplication
@MapperScan({ "com.demain.content.mapper" })
public class BlogContentController {

	public static void main(String[] args) {
		SpringApplication.run(BlogContentController.class, args);
	}

}
