package com.demain.common.core.handler;

import com.demain.common.core.exception.PlatformException;
import com.demain.common.core.util.Result;
import com.demain.i18n.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理
 *
 * @author demain_lee
 * @since 0.0.1
 */
@RestControllerAdvice
public class PlatformExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(PlatformExceptionHandler.class);

	/**
	 * 全局异常捕捉处理
	 */
	@ExceptionHandler(value = { Exception.class })
	public Result<?> handlerException(Exception exception, HttpServletRequest request) {
		log.error("请求路径uri={},系统内部出现异常:{}", request.getRequestURI(), exception);
		return Result.error(StatusCode.SYSTEM_EXECUTION_ERROR, exception.getLocalizedMessage());
	}

	/**
	 * 自定义异常-PlatformException
	 */
	@ExceptionHandler(value = { PlatformException.class })
	public Result<?> handlerCustomException(PlatformException exception, HttpServletRequest request) {
		String errorMessage = exception.getMsg();
		log.error("请求路径uri={},出现异常:{},异常信息:{}", request.getRequestURI(), exception, errorMessage);
		return Result.error(exception.getCode(), errorMessage);
	}

}
