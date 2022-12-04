package com.demain.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

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
@ApiModel(value = "User对象", description = "用户表")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("ID")
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	@ApiModelProperty("用户名")
	private String userName;

	@ApiModelProperty("密码")
	private String password;

	@ApiModelProperty("昵称")
	private String nickName;

	@ApiModelProperty("姓名")
	private String realName;

	@ApiModelProperty("邮箱")
	private String email;

	@ApiModelProperty("状态")
	private Byte status;

	@ApiModelProperty("创建人")
	private Long createUser;

	@ApiModelProperty("创建时间")
	private LocalDateTime createTime;

	@ApiModelProperty("更新人")
	private Long updateUser;

	@ApiModelProperty("更新时间")
	private LocalDateTime updateTime;

}
