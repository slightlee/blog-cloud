package com.demain.auth.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.demain.auth.entity.SysUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author demain_lee
 * @since 0.0.1
 */
@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

	private final SysUserService userService;

	public MyUserDetailsServiceImpl(SysUserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = userService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUserName, username));
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在或者密码错误");
		}
		return User.withUsername(user.getUserName()).password(user.getPassword()).authorities("admin").build();
	}

}
