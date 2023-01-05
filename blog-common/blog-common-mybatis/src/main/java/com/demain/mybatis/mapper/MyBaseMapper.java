package com.demain.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义扩展方法
 *
 * @author demain_lee
 * @since 0.0.1
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {

	/**
	 * 以下定义的 4个 default method, copy from
	 * {@link com.baomidou.mybatisplus.extension.toolkit.ChainWrappers}
	 */
	default QueryChainWrapper<T> queryChain() {
		return new QueryChainWrapper<>(this);
	}

	default LambdaQueryChainWrapper<T> lambdaQueryChain() {
		return new LambdaQueryChainWrapper<>(this);
	}

	default UpdateChainWrapper<T> updateChain() {
		return new UpdateChainWrapper<>(this);
	}

	default LambdaUpdateChainWrapper<T> lambdaUpdateChain() {
		return new LambdaUpdateChainWrapper<>(this);
	}

	// 以下定义的 3 个 method，是mybatisPlus内置的选装件

	/**
	 * 批量新增数据,自选字段 insert 不同的数据库支持度不一样!!! 只在 mysql 下测试过!!! 只在 mysql 下测试过!!! 只在 mysql
	 * 下测试过!!! 除了主键是 数据库自增的未测试 外理论上都可以使用!!!
	 * 如果你使用自增有报错或主键值无法回写到entity,就不要跑来问为什么了,因为我也不知道!!! 自己的通用 mapper 如下使用: int
	 * insertBatchSomeColumn(List entityList);
	 * <p>
	 * 注意: 这是自选字段 insert !!,如果个别字段在 entity 里为 null 但是数据库中有配置默认值, insert 后数据库字段是为 null
	 * 而不是默认值 常用的 Predicate: 例1: t -> !t.isLogicDelete() , 表示不要逻辑删除字段 例2: t ->
	 * !t.getProperty().equals("version") , 表示不要字段名为 version 的字段 例3: t -> t.getFieldFill()
	 * != FieldFill.UPDATE) , 表示不要填充策略为 UPDATE 的字段
	 * <p>
	 * {@link com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn}
	 * @param entityList 实体对象集合
	 * @return int
	 */
	int insertBatchSomeColumn(List<T> entityList);

	/**
	 * 根据 ID 更新固定的那几个字段(但是不包含逻辑删除) 自己的通用 mapper 如下使用: int
	 * alwaysUpdateSomeColumnById(@Param(Constants.ENTITY) T entity);
	 * <p>
	 * 如何筛选字段参考请 InsertBatchSomeColumn 里面的注释
	 * {@link com.baomidou.mybatisplus.extension.injector.methods.AlwaysUpdateSomeColumnById}
	 */
	int alwaysUpdateSomeColumnById(@Param(Constants.ENTITY) T entity);

	/**
	 * 试验功能,不做太复杂的功能,逻辑删除增加填充功能 如果想做的通用点的话,delete的时候如果是主键,在service层转换实体进行删除,
	 * 这样根据主键删除的也能自动填充
	 * 如果是逻辑删除且标记有填充字段的情况下,以第一条记录的填充字段为准(一切以当前的时间点为基准,如果无法接受记录记录时间不准确请使用循环删除)
	 * 由于本身SQL更新的限制限,这里记录集合不能为空,也不支持第一条记录删除人是A或者时间是A时间,第二条记录的时间是B时间 update table set
	 * (填充字段1,填充字段2,逻辑删除字段) where id in (主键1,主键2,主键3) 用法: 使用默认deleteBatchIds方法 注入方法: new
	 * LogicDeleteBatchByIds()
	 * <p>
	 * 自定义Mapper方法名: 注入方法: new LogicDeleteBatchByIds("testDeleteBatch") 增加Mapper方法: int
	 * testDeleteBatch(@Param(Constants.COLLECTION) List entityList);
	 * <p>
	 * Since: 3.5.0
	 * {@link com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteBatchByIds}
	 */
	int logicDeleteBatchByIds(@Param(Constants.COLL) List entityList);

}
