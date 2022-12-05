package com.demain.user.controller;

import com.demain.user.entity.User;
import com.demain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author demain_lee
 * @since 2022-12-05
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "用户管理")
@Slf4j
public class UserController {

	@Value("${server.port}")
	private String port;

	private final UserService userService;

	/**
	 * 根据用户ID获取用户信息
	 */
	@GetMapping("/getUserInfo/{id}")
	@Operation(summary = "根据内容ID获取内容信息")
	@Parameters({
			@Parameter(name = "id", description = "用户ID")
	})
	public User getUserInfo(@PathVariable("id") Long id) {
		log.info("被请求了:{}",port);
		return userService.getById(id);
	}

}
