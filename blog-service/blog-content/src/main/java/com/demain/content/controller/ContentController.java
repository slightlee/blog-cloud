package com.demain.content.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demain.common.core.util.Result;
import com.demain.content.entity.Content;
import com.demain.content.service.ContentService;
import com.demain.content.vo.ContentInfoV;
import com.demain.mybatis.core.conditions.Query;
import com.demain.user.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
@Tag(name = "内容管理")
@Slf4j
public class ContentController {

	private final ContentService contentService;

	private final RestTemplate restTemplate;

	/**
	 * 根据内容ID获取内容信息
	 */
	@GetMapping("/getContentInfo/{id}")
	@Operation(summary = "根据内容ID获取内容信息")
	@Parameters({ @Parameter(name = "id", description = "内容ID") })
	public Result<ContentInfoV> getContentInfo(@PathVariable("id") Long id) {

		// 内容信息
		Content content = contentService.getById(id);
		// 用户信息
		ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://blog-user/user/getUserInfo/{id}",
				User.class, id);
		User user = responseEntity.getBody();
		assert user != null;
		ContentInfoV contentInfoV = ContentInfoV.builder().content(content).nickName(user.getNickName()).build();
		return Result.data(contentInfoV);
	}

	/**
	 * 批量插入内容信息
	 */
	@PostMapping("/batchInsertContent")
	@Operation(summary = "批量插入内容信息")
	public Result<Boolean> batchInsertContent() {
		return Result.status(contentService.batchInsertContent());
	}

	/**
	 * 内容列表
	 */
	@GetMapping("/listContent")
	@Operation(summary = "内容列表")
	public Result<IPage<Content>> listContent(@ParameterObject Query query) {
		return Result.data(contentService.contentList(query));
	}

	@GetMapping("/updateContent")
	@Operation(summary = "更新内容")
	public Result<?> updateContent() {
		Content content = new Content();
		content.setId(1L);
		// 乐观锁测试
		content.setVersion(1);
		content.setTitle("测试");
		contentService.updateById(content);
		return Result.data(contentService.updateById(content));
	}

}
