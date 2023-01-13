package com.demain.user;

import com.demain.common.swagger.annotation.EnableDoc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 用户服务
 *
 * @author demain_lee
 * @since 0.0.1
 */
@EnableDoc
@SpringBootApplication
@MapperScan({ "com.demain.user.mapper" })
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
