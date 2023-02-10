package com.demain.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author demain_lee
 * @since 2023-02-10
 */
@Getter
@Setter
@TableName("sys_user")
@Schema(name = "SysUser对象", description = "用户表")
public class SysUser implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Schema(name = "ID")
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	@Schema(name = "用户名")
	private String userName;

	@Schema(name = "密码")
	private String password;

	@Schema(name = "昵称")
	private String nickName;

	@Schema(name = "姓名")
	private String realName;

	@Schema(name = "邮箱")
	private String email;

	@Schema(name = "状态")
	private Byte status;

	@Schema(name = "创建人")
	private Long createUser;

	@Schema(name = "创建时间")
	private LocalDateTime createTime;

	@Schema(name = "更新人")
	private Long updateUser;

	@Schema(name = "更新时间")
	private LocalDateTime updateTime;

}
