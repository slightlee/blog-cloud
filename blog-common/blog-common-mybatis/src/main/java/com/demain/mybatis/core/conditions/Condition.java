package com.demain.mybatis.core.conditions;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 分页构造器
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class Condition {

	/**
	 * 分页对象
	 * @param query 查询参数
	 * @return 分页对象
	 */
	public static <T> IPage<T> getPage(Query query) {
		return new Page<>(query.getCurrent() == null ? 1 : query.getCurrent(),
				query.getSize() == null ? 10 : query.getSize());
	}

}
