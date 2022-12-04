package com.demain.content.service.impl;

import com.demain.content.entity.Content;
import com.demain.content.mapper.ContentMapper;
import com.demain.content.service.ContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 内容表 服务实现类
 * </p>
 *
 * @author demain_lee
 * @since 2022-12-05
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentService {

}
