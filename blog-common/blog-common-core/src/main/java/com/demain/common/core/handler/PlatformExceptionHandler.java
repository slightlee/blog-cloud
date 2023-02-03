package com.demain.common.core.handler;

import com.demain.common.core.exception.PlatformException;
import com.demain.common.core.util.Result;
import com.demain.common.core.util.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

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
		return Result.error(ResultEnum.INTERNAL_SERVER_ERROR.getCode(), exception.getLocalizedMessage());
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

	/**
	 * 自定义validation异常-PlatformException
	 * BindException（@Validated @Valid仅对于表单提交有效，对于以json格式提交将会失效）
	 */
	@ExceptionHandler(value = { BindException.class })
	public Result<?> handlerValidationException(BindException exception, HttpServletRequest request) {
		log.error("请求路径uri={},出现异常:{}", request.getRequestURI(), exception);
		String errorMessage = exception.getBindingResult().getAllErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(";"));
		return Result.error(ResultEnum.PARAMETER_VALIDATION_FAIL.getCode(), errorMessage);
	}

	/**
	 * MethodArgumentNotValidException（@Validated @Valid 前端提交的方式为json格式有效，出现异常时会被该异常类处理）
	 */
	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public Result<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception,
			HttpServletRequest request) {
		log.error("请求路径uri={},出现异常:{}", request.getRequestURI(), exception);
		BindingResult bindingResult = exception.getBindingResult();
		ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
		String messages = objectError.getDefaultMessage();
		return Result.error(ResultEnum.PARAMETER_VALIDATION_FAIL.getCode(), messages);
	}

}
