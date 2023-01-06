package com.demain.content.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Content对象")
public class Content implements Serializable {

	private static final long serialVersionUID = 1L;

	@Schema(description = "ID")
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	private Long id;

	@Schema(description = "标题")
	private String title;

	@Schema(description = "内容")
	private String content;

	@Schema(description = "标签")
	private String tag;

	@Schema(description = "序号")
	private Integer sort;

	@Schema(description = "状态")
	private Integer status;

	@Schema(description = "创建人")
	private Long createUser;

	@Schema(description = "创建时间")
	private LocalDateTime createTime;

	@Schema(description = "更新人")
	private Long updateUser;

	@Schema(description = "更新时间")
	private LocalDateTime updateTime;

	/**
	 * 乐观锁
	 */
	@Version
	private Integer version;

}
