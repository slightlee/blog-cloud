package com.demain.content.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demain.content.entity.Content;
import com.demain.content.mapper.ContentMapper;
import com.demain.content.service.ContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demain.mybatis.core.conditions.Condition;
import com.demain.mybatis.core.conditions.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 内容表 服务实现类
 * </p>
 *
 * @author demain_lee
 * @since 2022-12-05
 */
@Service
@RequiredArgsConstructor
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentService {

	private final ContentMapper contentMapper;

	@Override
	public boolean batchInsertContent() {

		List<Content> contentsList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			Content content = new Content();
			content.setSort(i);
			content.setTitle("标题" + i);
			content.setStatus(0);
			content.setContent("内容" + i);
			contentsList.add(content);
			// contentMapper.insert(content);
		}

		// return true;

		return contentMapper.insertBatchSomeColumn(contentsList) > 0;
	}

	@Override
	public IPage<Content> contentList(Query query) {
		return contentMapper.selectPage(Condition.getPage(query), null);
	}
}
