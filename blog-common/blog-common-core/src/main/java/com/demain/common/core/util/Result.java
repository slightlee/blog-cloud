package com.demain.common.core.util;

import com.demain.i18n.StatusCode;
import com.demain.i18n.util.I18nMessageUtil;
import io.swagger.v3.oas.annotations.media.Schema;
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
@SuppressWarnings("unused")
public class Result<T> implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(Result.class);

	@Schema(description = "返回Code")
	private String code;

	@Schema(description = "描述信息")
	private String msg;

	@Schema(description = "返回数据")
	private T data;

	private Result(String code) {
		this.code = code;
		this.msg = I18nMessageUtil.getMessage(code);
	}

	private Result(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private Result(String code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static <T> Result<T> data(T data) {
		return new Result<>(StatusCode.OK, I18nMessageUtil.getMessage(StatusCode.OK), data);
	}

	/**
	 * 返回Result
	 * @param <T> T 响应数据
	 * @return Result
	 */
	public static <T> Result<T> success() {
		return new Result<>(StatusCode.OK);
	}

	/**
	 * 返回Result
	 * @param msg 消息
	 * @param <T> T 响应数据
	 * @return Result
	 */
	public static <T> Result<T> success(String msg) {
		return new Result<>(StatusCode.OK, msg);
	}

	/**
	 * 返回Result
	 * @param <T> T 响应数据
	 * @return Result
	 */
	public static <T> Result<T> error() {
		return new Result<>(StatusCode.SYSTEM_EXECUTION_ERROR);
	}

	/**
	 * 返回Result
	 * @param msg 消息
	 * @param <T> T 响应数据
	 * @return Result
	 */
	public static <T> Result<T> error(String msg) {
		logger.debug("返回错误：code={}, msg={}", StatusCode.SYSTEM_EXECUTION_ERROR, msg);
		return new Result<>(StatusCode.SYSTEM_EXECUTION_ERROR, msg);
	}

	/**
	 * 返回Result
	 * @param msg 消息
	 * @param <T> T 响应数据
	 * @return Result
	 */
	public static <T> Result<T> error(String code, String msg) {
		logger.debug("返回错误：code={}, msg={}", code, msg);
		return new Result<>(code, msg);
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
