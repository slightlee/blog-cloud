package com.demain.content.controller;

import com.demain.common.core.util.Result;
import com.demain.content.entity.Content;
import com.demain.content.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 内容表 前端控制器
 * </p>
 *
 * @author demain_lee
 * @since 2022-12-05
 */
@RestController
@RequestMapping("/content")
@RequiredArgsConstructor
public class ContentController {

	private final ContentService contentService;

	/**
	 * 根据内容ID获取内容信息
	 */
	@RequestMapping("/getContentInfo/{id}")
	public Result<Content> getContentInfo(@PathVariable("id") Long id) {
		return Result.data(contentService.getById(id));
	}

}
