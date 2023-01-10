package com.demain.mybatis.core.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.demain.mybatis.core.handler.MySqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 *
 * @author demain_lee
 * @since 0.0.1
 */
@Configuration
public class MybatisPlusConfig {

	/**
	 * 插件 版本要求：3.4.0 版本以上 注意:
	 * <p>
	 * 使用多个功能需要注意顺序关系,建议使用如下顺序
	 * <p>
	 * 多租户,动态表名 分页,乐观锁 sql 性能规范,防止全表更新与删除 总结: 对 sql 进行单次改造的优先放入,不对 sql 进行改造的最后放入
	 * @link <a href="https://baomidou.com/pages/2976a3/#mybatisplusinterceptor">...</a>
	 */
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {

		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		// 乐观锁插件
		interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
		// 分页插件 DbType：数据库类型(根据类型获取应使用的分页方言)
		interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
		// interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

		return interceptor;
	}

	/**
	 * 自定义 SqlInjector 里面包含自定义的全局方法
	 */
	@Bean
	public MySqlInjector myLogicSqlInjector() {
		return new MySqlInjector();
	}

}
