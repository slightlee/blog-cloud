package com.demain.common.core.exception;

import com.demain.common.core.util.ResultEnum;

/**
 * 自定义处理异常
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class PlatformException extends RuntimeException {

	private int code;

	private String msg;

	private String errorMsg;

	public PlatformException() {
		this.code = ResultEnum.INTERNAL_SERVER_ERROR.code;
		this.msg = ResultEnum.INTERNAL_SERVER_ERROR.msg;
	}

	public PlatformException(String message) {
		this.code = ResultEnum.INTERNAL_SERVER_ERROR.code;
		this.msg = message;
	}

	public PlatformException(ResultEnum resultCodeEnum) {
		this.code = resultCodeEnum.getCode();
		this.msg = resultCodeEnum.getMsg();
	}

	public PlatformException(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
