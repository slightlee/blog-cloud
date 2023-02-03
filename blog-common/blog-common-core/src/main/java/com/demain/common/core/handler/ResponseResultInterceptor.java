package com.demain.common.core.handler;

import com.demain.common.core.annotation.ResponseResult;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 响应拦截器
 *
 * @author demain_lee
 * @since 0.0.1
 */
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

	/**
	 * 使用统一返回体的标识
	 */
	private static final String RESPONSE_RESULT_ANNOTATION = "RESPONSE-RESULT-ANNOTATION";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		// 正在处理请求的方法bean
		if (handler instanceof HandlerMethod) {
			final HandlerMethod handlerMethod = (HandlerMethod) handler;
			// 获取当前类
			final Class<?> clazz = handlerMethod.getBeanType();
			// 获取当前方法
			final Method method = handlerMethod.getMethod();
			// 判断是否在类对象上加了注解
			if (clazz.isAnnotationPresent(ResponseResult.class)) {
				// 设置该请求返回体，需要包装，往下传递，在ResponseBodyAdvice接口进行判断
				request.setAttribute(RESPONSE_RESULT_ANNOTATION, clazz.getAnnotation(ResponseResult.class));
			}
			// 判断是否在方法上加了注解
			else if (method.isAnnotationPresent(ResponseResult.class)) {
				// 设置该请求返回体，需要包装，往下传递，在ResponseBodyAdvice接口进行判断
				request.setAttribute(RESPONSE_RESULT_ANNOTATION, method.getAnnotation(ResponseResult.class));
			}
		}
		return true;
	}

}
