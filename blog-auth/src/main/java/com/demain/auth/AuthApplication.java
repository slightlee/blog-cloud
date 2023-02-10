package com.demain.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 认证授权服务
 *
 * @author demain_lee
 * @since 0.0.1
 */
@SpringBootApplication
@MapperScan("com.demain.auth.mapper")
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}
