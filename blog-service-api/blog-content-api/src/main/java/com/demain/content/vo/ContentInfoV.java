package com.demain.content.vo;

import com.demain.content.entity.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 内容信息
 *
 * @author demain_lee
 * @since 2022/12/5
 */
@Builder
@Data
public class ContentInfoV implements Serializable {

	private static final long serialVersionUID = 1L;

	@Schema(description = "内容信息")
	private Content content;

	@Schema(description = "昵称")
	private String nickName;

}
