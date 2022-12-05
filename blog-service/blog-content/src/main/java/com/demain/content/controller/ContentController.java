package com.demain.content.controller;

import com.demain.common.core.util.Result;
import com.demain.content.entity.Content;
import com.demain.content.service.ContentService;
import com.demain.content.vo.ContentInfoV;
import com.demain.user.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

	private final DiscoveryClient discoveryClient;

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
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://blog-user/user/getUserInfo/{id}", User.class, id);
		User user = responseEntity.getBody();
		assert user != null;
		ContentInfoV contentInfoV = ContentInfoV.builder().content(content).nickName(user.getNickName()).build();
		return Result.data(contentInfoV);
	}

}
