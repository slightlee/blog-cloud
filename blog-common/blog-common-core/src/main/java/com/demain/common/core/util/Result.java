package com.demain.common.core.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 统一返回结果
 *
 * @param <T>
 * @author demain_lee
 * @since 0.0.1
 */
@Data
public class Result<T> implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(Result.class);

	@Schema(description = "返回Code")
	private Integer code;

	@Schema(description = "描述信息")
	private String msg;

	@Schema(description = "返回数据")
	private T data;

	private Result(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private Result(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	private Result(ResultEnum resultEnum) {
		this(resultEnum.getCode(), resultEnum.getMsg());
	}

	private Result(ResultEnum resultEnum, String msg) {
		this(resultEnum, msg, null);
	}

	private Result(ResultEnum resultEnum, String msg, T data) {
		this(resultEnum.code, msg, data);
	}

	public static <T> Result<T> data(T data) {
		return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
	}

	/**
	 * 返回Result
	 * @param <T> T 响应数据
	 * @return Result
	 */
	public static <T> Result<T> success() {
		return new Result<>(ResultEnum.SUCCESS);
	}

	/**
	 * 返回Result
	 * @param msg 消息
	 * @param <T> T 响应数据
	 * @return Result
	 */
	public static <T> Result<T> success(String msg) {
		return new Result<>(ResultEnum.SUCCESS, msg);
	}

	/**
	 * 返回Result
	 * @param resultEnum 返回枚举
	 * @param <T> T 响应数据
	 * @return Result
	 */
	public static <T> Result<T> success(ResultEnum resultEnum) {
		return new Result<>(resultEnum.getCode(), resultEnum.getMsg());
	}

	/**
	 * 返回Result
	 * @param <T> T 响应数据
	 * @return Result
	 */
	public static <T> Result<T> error() {
		logger.debug("返回错误：code={}, msg={}", ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getMsg());
		return error(ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getMsg());
	}

	/**
	 * 返回Result
	 * @param msg 消息
	 * @param <T> T 响应数据
	 * @return Result
	 */
	public static <T> Result<T> error(String msg) {
		logger.debug("返回错误：code={}, msg={}", ResultEnum.FAILED.getCode(), msg);
		return error(ResultEnum.FAILED.getCode(), msg);
	}

	/**
	 * 返回Result
	 * @param resultEnum 返回枚举
	 * @param <T> T 响应数据
	 * @return Result
	 */
	public static <T> Result<T> error(ResultEnum resultEnum) {
		logger.debug("返回错误：code={}, msg={}", resultEnum.getCode(), resultEnum.getMsg());
		return error(resultEnum.getCode(), resultEnum.getMsg());
	}

	/**
	 * 返回Result
	 * @param code code
	 * @param msg msg
	 * @param <T> T 响应数据
	 * @return Result
	 */
	public static <T> Result<T> error(int code, String msg) {
		logger.debug("返回错误：code={}, msg={}", code, msg);
		return new Result<>(code, msg, null);
	}

	/**
	 * 返回Result
	 * @param flag flag
	 * @param <T> T 响应数据
	 * @return Result
	 */
	public static <T> Result<T> status(boolean flag) {
		return flag ? success() : error();
	}

}
