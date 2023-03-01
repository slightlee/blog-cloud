package com.demain.common.core.exception;

import com.demain.i18n.StatusCode;
import com.demain.i18n.util.I18nMessageUtil;

/**
 * 自定义处理异常
 *
 * @author demain_lee
 * @since 0.0.1
 */
@SuppressWarnings("unused")
public class PlatformException extends RuntimeException {

	private String code;

	private String msg;

	private String errorMsg;

	public PlatformException() {
		this.code = StatusCode.SYSTEM_EXECUTION_ERROR;
		this.msg = I18nMessageUtil.getMessage(StatusCode.SYSTEM_EXECUTION_ERROR);
	}

	public PlatformException(String message) {
		this.code = StatusCode.SYSTEM_EXECUTION_ERROR;
		this.msg = message;
	}

	public PlatformException(String code, String msg) {
		this.code = code;
		this.msg = msg;
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

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
