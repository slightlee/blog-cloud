package com.demain.content;

import com.demain.common.swagger.annotation.EnableDoc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 内容服务
 *
 * @author demain_lee
 * @since 0.0.1
 */
@EnableDoc
@SpringBootApplication
@MapperScan({ "com.demain.content.mapper" })
public class ContentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentApplication.class, args);
	}

}
