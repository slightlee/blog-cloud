package com.demain.mybatis.core.handler;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.AlwaysUpdateSomeColumnById;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteBatchByIds;

import java.util.List;

/**
 * 自定义sql注入器
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class MySqlInjector extends DefaultSqlInjector {

	/**
	 * 如果只需增加方法，保留MP自带方法 可以super.getMethodList() 再add
	 */
	@Override
	public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
		List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);

		// 加入选装件InsertBatchSomeColumn
		methodList.add(new InsertBatchSomeColumn(i -> i.getFieldFill() != FieldFill.UPDATE));

		// 加入选装件AlwaysUpdateSomeColumnById 主要功能是根据id更新固定的某些字段。
		methodList.add(new AlwaysUpdateSomeColumnById());

		// 加入选装件LogicDeleteByIdWithFill 主要功能是根据id逻辑删除数据并带字段填充功能。例如在删除的时候需要添加操作人
		methodList.add(new LogicDeleteBatchByIds("logicDeleteBatchByIds"));

		// 以下配置 更新时候不会更新name
		// methodList.add(new AlwaysUpdateSomeColumnById(t->!"name".equals(t.getColumn())));

		return methodList;
	}

}
