package com.demain.content.service;

import com.demain.content.entity.Content;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 内容表 服务类
 * </p>
 *
 * @author demain_lee
 * @since 2022-12-05
 */
public interface ContentService extends IService<Content> {

	/**
	 * 批量插入
	 * @return boolean
	 */
	boolean batchInsertContent();

}
