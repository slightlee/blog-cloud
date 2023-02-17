package com.demain.auth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * oauth2客户端配置-扩展表
 * </p>
 *
 * @author demain_lee
 * @since 2023-02-16
 */
@Getter
@Setter
@TableName("oauth2_client_settings")
@Schema(name = "Oauth2ClientSettings对象", description = "oauth2客户端配置-扩展表")
@Builder
public class Oauth2ClientSettings implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(name = "oauth2客户端id")
    private String registeredClientId;

    @Schema(name = "客户端是否需要证明密钥")
    private Boolean requireProofKey;

    @Schema(name = "客户端是否需要授权确认页面")
    private Boolean requireAuthorizationConsent;

    @Schema(name = "jws url")
    private String jwkSetUrl;

    @Schema(name = "支持的签名算法")
    private String tokenEndpointAuthenticationSigningAlgorithm;


}
