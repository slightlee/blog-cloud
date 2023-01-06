package com.demain.mybatis.core.conditions;

/**
 * 分页查询构造器
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class Query {

	/**
	 * 当前页
	 */
	private Integer current;

	/**
	 * 每页显示条数
	 */
	private Integer size;

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
