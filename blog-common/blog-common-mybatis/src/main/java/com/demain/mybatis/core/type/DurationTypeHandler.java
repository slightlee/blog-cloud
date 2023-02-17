package com.demain.mybatis.core.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;

/**
 * 自定义Duration类型处理器
 * <p>
 * Mysql 中的字段类型 为 BigInt ，Java程序中的属性类型为 Duration
 *
 * @author demain_lee
 * @since 0.0.1
 * @see org.apache.ibatis.type.TypeHandler
 */
public class DurationTypeHandler extends BaseTypeHandler<Duration> {

	public DurationTypeHandler() {
	}

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, Duration duration, JdbcType jdbcType)
			throws SQLException {
		preparedStatement.setLong(i, duration.getSeconds());
	}

	/**
	 * Gets the nullable result.
	 * @param rs the rs
	 * @param columnName Column name, when configuration <code>useColumnLabel</code> is
	 * <code>false</code>
	 * @return the nullable result
	 * @throws SQLException the SQL exception
	 */
	@Override
	public Duration getNullableResult(ResultSet rs, String columnName) throws SQLException {
		long value = rs.getLong(columnName);
		return Duration.ofSeconds(value);
	}

	@Override
	public Duration getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		long value = rs.getLong(columnIndex);
		return Duration.ofSeconds(value);
	}

	@Override
	public Duration getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		long value = cs.getLong(columnIndex);
		return Duration.ofSeconds(value);
	}

}
