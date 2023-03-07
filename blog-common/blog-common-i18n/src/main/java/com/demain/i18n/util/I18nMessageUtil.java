package com.demain.i18n.util;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * 国际化工具类
 *
 * @author demain_lee
 * @since 0.0.1
 * @see <a href=
 * "https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#context-functionality-messagesource">...</a>
 */
@SuppressWarnings("unused")
public class I18nMessageUtil {

	private static final ReloadableResourceBundleMessageSource RESOURCE_BUNDLE_MESSAGE_SOURCE = new ReloadableResourceBundleMessageSource();

	static {
		RESOURCE_BUNDLE_MESSAGE_SOURCE.setDefaultEncoding(StandardCharsets.UTF_8.name());
		RESOURCE_BUNDLE_MESSAGE_SOURCE.setBasename("classpath:i18n/message");
	}

	public static String getMessage(String code) {
		return RESOURCE_BUNDLE_MESSAGE_SOURCE.getMessage(code, new String[0], Locale.CHINA);
	}

	// public static void main(String[] args) {
	// System.out.println(getMessage("00000"));
	// }

}
