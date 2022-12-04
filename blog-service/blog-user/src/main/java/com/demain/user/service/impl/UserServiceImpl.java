package com.demain.user.service.impl;

import com.demain.user.entity.User;
import com.demain.user.mapper.UserMapper;
import com.demain.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author demain_lee
 * @since 2022-12-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
