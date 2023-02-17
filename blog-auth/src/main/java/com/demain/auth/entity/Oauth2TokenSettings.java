package com.demain.auth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.demain.mybatis.core.type.DurationTypeHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Duration;

/**
 * <p>
 * oauth2客户端token配置-扩展表
 * </p>
 *
 * @author demain_lee
 * @since 2023-02-16
 */
@Getter
@Setter
@TableName(value = "oauth2_token_settings", autoResultMap = true)
@Schema(name = "Oauth2TokenSettings对象", description = "oauth2客户端token配置-扩展表")
@Builder
public class Oauth2TokenSettings implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Schema(name = "oauth2客户端id")
	private String registeredClientId;

	@Schema(name = "设置授权代码的生存时间 必须大于0，建议授权代码的最长生存期为 10 分钟")
	@TableField(typeHandler = DurationTypeHandler.class)
	private Duration authorizationCodeTimeToLive;

	@Schema(name = "access_token 有效时间")
	@TableField(typeHandler = DurationTypeHandler.class)
	private Duration accessTokenTimeToLive;

	@Schema(name = "token 格式")
	private String accessTokenFormat;

	@Schema(name = "是否重复使用 refresh_token")
	private Boolean reuseRefreshTokens;

	@Schema(name = "refresh_token 有效时间 ")
	@TableField(typeHandler = DurationTypeHandler.class)
	private Duration refreshTokenTimeToLive;

	@Schema(name = "oidc id_token 签名算法")
	private String idTokenSignatureAlgorithm;

	public Oauth2TokenSettings() {
	}

	public Oauth2TokenSettings(String registeredClientId, Duration authorizationCodeTimeToLive,
			Duration accessTokenTimeToLive, String accessTokenFormat, Boolean reuseRefreshTokens,
			Duration refreshTokenTimeToLive, String idTokenSignatureAlgorithm) {
		this.registeredClientId = registeredClientId;
		this.authorizationCodeTimeToLive = authorizationCodeTimeToLive;
		this.accessTokenTimeToLive = accessTokenTimeToLive;
		this.accessTokenFormat = accessTokenFormat;
		this.reuseRefreshTokens = reuseRefreshTokens;
		this.refreshTokenTimeToLive = refreshTokenTimeToLive;
		this.idTokenSignatureAlgorithm = idTokenSignatureAlgorithm;
	}

	@Override
	public String toString() {
		return "Oauth2TokenSettings{" + "registeredClientId='" + registeredClientId + '\''
				+ ", authorizationCodeTimeToLive=" + authorizationCodeTimeToLive + ", accessTokenTimeToLive="
				+ accessTokenTimeToLive + ", accessTokenFormat='" + accessTokenFormat + '\'' + ", reuseRefreshTokens="
				+ reuseRefreshTokens + ", refreshTokenTimeToLive=" + refreshTokenTimeToLive
				+ ", idTokenSignatureAlgorithm='" + idTokenSignatureAlgorithm + '\'' + '}';
	}

}
