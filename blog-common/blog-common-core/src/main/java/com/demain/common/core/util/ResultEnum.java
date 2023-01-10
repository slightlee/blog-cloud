package com.demain.common.core.util;

/**
 * 返回结果枚举类
 *
 * @author demain_lee
 * @since 0.0.1
 */
public enum ResultEnum {

	// 2xx - 成功
	SUCCESS(200, "操作成功"),

	// 3xx - 重定向

	// 4xx - 请求错误
	BAD_REQUEST(400, "错误请求"), UNAUTHORIZED(401, "未授权"), FORBIDDEN(403, "服务器拒绝请求"), NOT_FOUND(404, "未找到"),
	METHOD_NOT_ALLOWED(405, "客户端请求中的方法被禁止"),

	// 5xx - 服务器错误
	INTERNAL_SERVER_ERROR(500, "服务器内部错误"), NOT_IMPLEMENTED(501, "尚未实施"), BAD_GATEWAY(502, "错误网关"),
	SERVICE_UNAVAILABLE(503, "服务不可用"), GATEWAY_TIME_OUT(504, "网关超时"), HTTP_VERSION_NOT_SUPPORTED(505, "HTTP 版本不受支持"),

	// 操作失败
	FAILED(9001, "操作失败"),

	// 业务

	// --- 权限验证返回码 1xxx ---
	UNSUPPORTED_GRANT_TYPE(1001, "不支持的认证方式"), ACCOUNT_PASSWORD_IS_ERROR(1002, "账号或密码错误"),
	CLIENT_AUTHENTICATION_FAILED(1003, "客户端认证失败"), NO_PERMISSION(1004, "无权限访问"), TOKEN_INVALID(1005, "Token无效"),
	ACCOUNT_NOT_EXIST(1006, "账号不存在"), PASSWORD_CHECK_FAIL(1007, "密码校验失败"), ACCOUNT_DISABLE(1008, "账号被禁用"),
	UN_AUTHENTICATED(1009, "您还未登录"),

	// ---操作数据返回码 3xxx ----
	ADD_FAIL(3001, "添加失败"), UPDATE_FAIL(3002, "修改失败"), DELETE_FAIL(3003, "删除失败"), SEND_FAIL(3004, "发送失败"),
	QUERY_FAIL(3005, "查询失败"),

	// ----参数----- 4xxx ---
	ILLEGAL_PARAMETER(4001, "参数不合法"), OLD_PASSWORD_ERROR(4002, "旧密码错误"), FILE_FORMAT_IS_ERROR(4003, "请上传指定格式的文件"),
	PARAMETER_VALIDATION_FAIL(4004, "参数校验失败");

	/**
	 * 错误类型码
	 */
	public final int code;

	/**
	 * 错误类型描述信息
	 */
	public final String msg;

	ResultEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
