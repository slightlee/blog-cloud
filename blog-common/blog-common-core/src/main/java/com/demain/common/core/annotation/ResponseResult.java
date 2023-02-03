package com.demain.common.core.annotation;

import java.lang.annotation.*;

/**
 * 自定义响应结果注解
 *
 * @author demain_lee
 * @since 0.0.1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
public @interface ResponseResult {

}
