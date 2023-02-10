package com.demain.auth.service.impl;

import com.demain.auth.entity.SysUser;
import com.demain.auth.mapper.SysUserMapper;
import com.demain.auth.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author demain_lee
 * @since 2023-02-10
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
