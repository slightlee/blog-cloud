package com.demain.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

/**
 * <p>
 *
 * </p>
 *
 * @author demain_lee
 * @since 2023-02-16
 */
@Getter
@Setter
@TableName("oauth2_registered_client")
@Schema(name = "Oauth2RegisteredClient对象", description = "Oauth2RegisteredClient表")
@Builder
public class Oauth2RegisteredClient implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    private String clientId;

    private Instant clientIdIssuedAt;

    private String clientSecret;

    private Instant clientSecretExpiresAt;

    private String clientName;

    private String clientAuthenticationMethods;

    private String authorizationGrantTypes;

    private String redirectUris;

    private String scopes;

    /**
     * 方案一：单独 oauth2_client_settings 表
     * 方案二：存放json格式数据
     * 默认使用方案一
     */
    private String clientSettings;

    /**
     * 方案一：单独 oauth2_token_settings 表
     * 方案二：存放json格式数据
     * 默认使用方案一
     */
    private String tokenSettings;
}
