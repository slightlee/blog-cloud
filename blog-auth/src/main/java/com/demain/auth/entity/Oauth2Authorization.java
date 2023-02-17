package com.demain.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
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
@TableName("oauth2_authorization")
@Schema(name = "Oauth2Authorization对象", description = "Oauth2Authorization表")
public class Oauth2Authorization implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    private String registeredClientId;

    private String principalName;

    private String authorizationGrantType;

    private String authorizedScopes;

    private String attributes;

    private String state;

    private String authorizationCodeValue;

    /**
     * eg: 2023-02-16T08:23:04.821522800Z
     */
    private Instant authorizationCodeIssuedAt;

    private Instant authorizationCodeExpiresAt;

    private String authorizationCodeMetadata;

    private String accessTokenValue;

    private Instant accessTokenIssuedAt;

    private Instant accessTokenExpiresAt;

    private String accessTokenMetadata;

    private String accessTokenType;

    private String accessTokenScopes;

    private String oidcIdTokenValue;

    private Instant oidcIdTokenIssuedAt;

    private Instant oidcIdTokenExpiresAt;

    private String oidcIdTokenMetadata;

    private String refreshTokenValue;

    private Instant refreshTokenIssuedAt;

    private Instant refreshTokenExpiresAt;

    private String refreshTokenMetadata;
}
