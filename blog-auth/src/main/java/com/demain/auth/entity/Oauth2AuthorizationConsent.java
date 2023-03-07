package com.demain.auth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

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
@TableName("oauth2_authorization_consent")
@Schema(name = "Oauth2AuthorizationConsent对象", description = "Oauth2AuthorizationConsent表")
public class Oauth2AuthorizationConsent implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private String registeredClientId;

	private String principalName;

	private String authorities;

}
