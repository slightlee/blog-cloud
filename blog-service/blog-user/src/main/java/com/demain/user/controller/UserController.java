package com.demain.user.controller;

import com.demain.user.entity.User;
import com.demain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
public class UserController {

	private final UserService userService;

	/**
	 * 根据用户ID获取用户信息
	 */
	@GetMapping("/getUserInfo")
	public User getUserInfo() {
		return userService.getById(1);
	}

}
