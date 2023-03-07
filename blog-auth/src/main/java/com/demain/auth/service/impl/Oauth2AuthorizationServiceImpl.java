package com.demain.auth.service.impl;

import com.demain.auth.entity.Oauth2Authorization;
import com.demain.auth.mapper.Oauth2AuthorizationMapper;
import com.demain.auth.service.Oauth2AuthorizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author demain_lee
 * @since 2023-02-16
 */
@Service
public class Oauth2AuthorizationServiceImpl extends ServiceImpl<Oauth2AuthorizationMapper, Oauth2Authorization>
		implements Oauth2AuthorizationService {

}
