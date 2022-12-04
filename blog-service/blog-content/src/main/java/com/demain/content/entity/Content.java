package com.demain.content.entity;

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
 * 内容表
 * </p>
 *
 * @author demain_lee
 * @since 2022-12-05
 */
@Getter
@Setter
@TableName("blog_content")
@ApiModel(value = "Content对象", description = "内容表")
public class Content implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("ID")
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	@ApiModelProperty("标题")
	private String title;

	@ApiModelProperty("内容")
	private String content;

	@ApiModelProperty("标签")
	private String tag;

	@ApiModelProperty("序号")
	private Integer sort;

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
