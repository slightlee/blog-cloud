package com.demain.auth.service.impl;

import com.demain.auth.entity.Oauth2TokenSettings;
import com.demain.auth.mapper.Oauth2TokenSettingsMapper;
import com.demain.auth.service.Oauth2TokenSettingsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * oauth2客户端token配置-扩展表 服务实现类
 * </p>
 *
 * @author demain_lee
 * @since 2023-02-16
 */
@Service
public class Oauth2TokenSettingsServiceImpl extends ServiceImpl<Oauth2TokenSettingsMapper, Oauth2TokenSettings> implements Oauth2TokenSettingsService {

}
