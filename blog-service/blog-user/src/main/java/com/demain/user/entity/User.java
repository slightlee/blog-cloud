package com.demain.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author demain_lee
 * @since 2022-12-05
 */
@Getter
@Setter
@TableName("blog_user")
@Schema(description = "User对象")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Schema(description = "ID")
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	@Schema(description = "用户名")
	private String userName;

	@Schema(description = "密码")
	private String password;

	@Schema(description = "昵称")
	private String nickName;

	@Schema(description = "姓名")
	private String realName;

	@Schema(description = "邮箱")
	private String email;

	@Schema(description = "状态")
	private Byte status;

	@Schema(description = "创建人")
	private Long createUser;

	@Schema(description = "创建时间")
	private LocalDateTime createTime;

	@Schema(description = "更新人")
	private Long updateUser;

	@Schema(description = "更新时间")
	private LocalDateTime updateTime;

}
