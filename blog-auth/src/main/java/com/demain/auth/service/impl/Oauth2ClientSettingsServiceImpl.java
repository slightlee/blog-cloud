package com.demain.auth.service.impl;

import com.demain.auth.entity.Oauth2ClientSettings;
import com.demain.auth.mapper.Oauth2ClientSettingsMapper;
import com.demain.auth.service.Oauth2ClientSettingsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * oauth2客户端配置-扩展表 服务实现类
 * </p>
 *
 * @author demain_lee
 * @since 2023-02-16
 */
@Service
public class Oauth2ClientSettingsServiceImpl extends ServiceImpl<Oauth2ClientSettingsMapper, Oauth2ClientSettings>
		implements Oauth2ClientSettingsService {

}
