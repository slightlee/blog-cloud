package com.demain.auth.service.impl;

import com.demain.auth.entity.Oauth2RegisteredClient;
import com.demain.auth.mapper.Oauth2RegisteredClientMapper;
import com.demain.auth.service.Oauth2RegisteredClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author demain_lee
 * @since 2023-02-16
 */
@Service
public class Oauth2RegisteredClientServiceImpl extends ServiceImpl<Oauth2RegisteredClientMapper, Oauth2RegisteredClient> implements Oauth2RegisteredClientService {

}
