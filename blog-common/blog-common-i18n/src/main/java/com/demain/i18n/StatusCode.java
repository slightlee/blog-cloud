package com.demain.i18n;

/**
 * 状态码
 *
 * @author demain_lee
 * @since 0.0.1
 */
@SuppressWarnings("unused")
public interface StatusCode {

	/**
	 * 请求成功
	 */
	String OK = "00000";

	/**
	 * 用户端错误
	 */
	String CLIENT_ERROR = "A0001";

	/**
	 * 用户注册错误
	 */
	String USER_REGISTRATION_ERROR = "A0100";

	/**
	 * 用户未同意隐私协议
	 */
	String USER_NOT_AGREE_PRIVACY_AGREEMENT = "A0101";

	/**
	 * 注册国家或地区受限
	 */
	String LIMITED_REGISTRATION_COUNTRY_OR_REGION = "A0102";

	/**
	 * 用户名为空
	 */
	String USERNAME_IS_EMPTY = "A0105";

	/**
	 * 密码为空
	 */
	String PASSWORD_IS_EMPTY = "A0106";

	/**
	 * 用户名校验失败
	 */
	String USERNAME_VERIFICATION_FAILED = "A0110";

	/**
	 * 用户名已存在
	 */
	String USERNAME_ALREADY_EXISTS = "A0111";

	/**
	 * 用户名包含敏感词
	 */
	String USERNAME_CONTAINS_SENSITIVE_WORDS = "A0112";

	/**
	 * 用户名包含特殊字符
	 */
	String USERNAME_CONTAINS_SPECIAL_CHARACTERS = "A0113";

	/**
	 * 密码校验失败
	 */
	String PASSWORD_VERIFICATION_FAILED = "A0120";

	/**
	 * 密码长度不够
	 */
	String PASSWORD_LENGTH_NOT_ENOUGH = "A0121";

	/**
	 * 密码强度不够
	 */
	String INSUFFICIENT_PASSWORD_STRENGTH = "A0122";

	/**
	 * 校验码输入错误
	 */
	String CHECK_CODE_INPUT_ERROR = "A0130";

	/**
	 * 短信校验码输入错误
	 */
	String SMS_VERIFICATION_CODE_INPUT_ERROR = "A0131";

	/**
	 * 邮件校验码输入错误
	 */
	String EMAIL_VERIFICATION_CODE_INPUT_ERROR = "A0132";

	/**
	 * 语音校验码输入错误
	 */
	String VOICE_VERIFICATION_CODE_INPUT_ERROR = "A0133";

	/**
	 * 用户证件异常
	 */
	String USER_ID_IS_ABNORMAL = "A0140";

	/**
	 * 用户证件类型未选择
	 */
	String USER_ID_TYPE_NOT_SELECTED = "A0141";

	/**
	 * 大陆身份证编号校验非法
	 */
	String ILLEGAL_VERIFICATION_OF_MAINLAND_ID_CARD_NUMBER = "A0142";

	/**
	 * 护照编号校验非法
	 */
	String ILLEGAL_VERIFICATION_OF_PASSPORT_NUMBER = "A0143";

	/**
	 * 军官证编号校验非法
	 */
	String ILLEGAL_VERIFICATION_OF_OFFICER_CERTIFICATE_NUMBER = "A0144";

	/**
	 * 用户基本信息校验失败
	 */
	String VERIFICATION_OF_USER_BASIC_INFORMATION_FAILED = "A0150";

	/**
	 * 手机格式校验失败
	 */
	String MOBILE_PHONE_FORMAT_VERIFICATION_FAILED = "A0151";

	/**
	 * 地址格式校验失败
	 */
	String ADDRESS_FORMAT_VERIFICATION_FAILED = "A0152";

	/**
	 * 邮箱格式校验失败
	 */
	String EMAIL_FORMAT_VERIFICATION_FAILED = "A0153";

	/**
	 * 用户登录异常
	 */
	String USER_LOGIN_EXCEPTION = "A0200";

	/**
	 * 用户账户不存在
	 */
	String USER_ACCOUNT_DOES_NOT_EXIST = "A0201";

	/**
	 * 用户账户被冻结
	 */
	String USER_ACCOUNT_IS_FROZEN = "A0202";

	/**
	 * 用户账户已作废
	 */
	String USER_ACCOUNT_HAS_BEEN_VOIDED = "A0203";

	/**
	 * 用户密码错误
	 */
	String USER_PASSWORD_ERROR = "A0210";

	/**
	 * 用户输入密码错误次数超限
	 */
	String THE_NUMBER_OF_INCORRECT_USER_INPUT_PASSWORD_EXCEEDS_THE_LIMIT = "A0211";

	/**
	 * 用户身份校验失败
	 */
	String USER_AUTHENTICATION_FAILED = "A0220";

	/**
	 * 用户指纹识别失败
	 */
	String USER_FINGERPRINT_IDENTIFICATION_FAILED = "A0221";

	/**
	 * 用户面容识别失败
	 */
	String USER_FACE_RECOGNITION_FAILED = "A0222";

	/**
	 * 用户未获得第三方登录授权
	 */
	String USER_IS_NOT_AUTHORIZED_TO_LOG_IN_BY_A_THIRD_PARTY = "A0223";

	/**
	 * 用户登录已过期
	 */
	String USER_LOGIN_HAS_EXPIRED = "A0230";

	/**
	 * 用户验证码错误
	 */
	String USER_VERIFICATION_CODE_ERROR = "A0240";

	/**
	 * 用户验证码尝试次数超限
	 */
	String THE_NUMBER_OF_USER_VERIFICATION_CODE_ATTEMPTS_EXCEEDS_THE_LIMIT = "A0241";

	/**
	 * 访问权限异常
	 */
	String ACCESS_PERMISSION_EXCEPTION = "A0300";

	/**
	 * 访问未授权
	 */
	String UNAUTHORIZED_ACCESS = "A0301";

	/**
	 * 正在授权中
	 */
	String AUTHORIZING = "A0302";

	/**
	 * 用户授权申请被拒绝
	 */
	String USER_AUTHORIZATION_APPLICATION_WAS_REJECTED = "A0303";

	/**
	 * 因访问对象隐私设置被拦截
	 */
	String BLOCKED_DUE_TO_ACCESS_OBJECT_PRIVACY_SETTINGS = "A0310";

	/**
	 * 授权已过期
	 */
	String THE_AUTHORIZATION_HAS_EXPIRED = "A0311";

	/**
	 * 无权限使用 API
	 */
	String NO_PERMISSION_TO_USE_API = "A0312";

	/**
	 * 用户访问被拦截
	 */
	String USER_ACCESS_IS_BLOCKED = "A0320";

	/**
	 * 黑名单用户
	 */
	String BLACKLIST_USERS = "A0321";

	/**
	 * 账号被冻结
	 */
	String ACCOUNT_BLOCKED = "A0322";

	/**
	 * 非法 IP 地址
	 */
	String ILLEGAL_IP_ADDRESS = "A0323";

	/**
	 * 网关访问受限
	 */
	String GATEWAY_ACCESS_IS_RESTRICTED = "A0324";

	/**
	 * 地域黑名单
	 */
	String REGIONAL_BLACKLIST = "A0325";

	/**
	 * 服务已欠费
	 */
	String SERVICE_OVERDUE = "A0330";

	/**
	 * 用户签名异常
	 */
	String USER_SIGNATURE_EXCEPTION = "A0340";

	/**
	 * RSA 签名错误
	 */
	String RSA_SIGNATURE_ERROR = "A0341";

	/**
	 * 用户请求参数错误
	 */
	String USER_REQUEST_PARAMETER_ERROR = "A0400";

	/**
	 * 包含非法恶意跳转链接
	 */
	String CONTAINS_ILLEGAL_MALICIOUS_JUMP_LINKS = "A0401";

	/**
	 * 无效的用户输入
	 */
	String INVALID_USER_INPUT = "A0402";

	/**
	 * 请求必填参数为空
	 */
	String THE_REQUIRED_PARAMETER_OF_THE_REQUEST_IS_EMPTY = "A0410";

	/**
	 * 用户订单号为空
	 */
	String THE_USER_ORDER_NUMBER_IS_EMPTY = "A0411";

	/**
	 * 订购数量为空
	 */
	String ORDER_QUANTITY_IS_EMPTY = "A0412";

	/**
	 * 缺少时间戳参数
	 */
	String MISSING_TIMESTAMP_PARAMETER = "A0413";

	/**
	 * 非法的时间戳参数
	 */
	String ILLEGAL_TIMESTAMP_PARAMETER = "A0414";

	/**
	 * 请求参数值超出允许的范围
	 */
	String THE_REQUEST_PARAMETER_VALUE_EXCEEDS_THE_ALLOWED_RANGE = "A0420";

	/**
	 * 参数格式不匹配
	 */
	String PARAMETER_FORMAT_DOES_NOT_MATCH = "A0421";

	/**
	 * 地址不在服务范围
	 */
	String THE_ADDRESS_IS_NOT_IN_THE_SERVICE_SCOPE = "A0422";

	/**
	 * 时间不在服务范围
	 */
	String TIME_IS_NOT_WITHIN_THE_SCOPE_OF_SERVICE = "A0423";

	/**
	 * 金额超出限制
	 */
	String AMOUNT_EXCEEDS_LIMIT = "A0424";

	/**
	 * 数量超出限制
	 */
	String QUANTITY_EXCEEDS_THE_LIMIT = "A0425";

	/**
	 * 请求批量处理总个数超出限制
	 */
	String THE_TOTAL_NUMBER_OF_REQUESTS_FOR_BATCH_PROCESSING_EXCEEDS_THE_LIMIT = "A0426";

	/**
	 * 请求 JSON 解析失败
	 */
	String FAILED_TO_REQUEST_JSON_PARSING = "A0427";

	/**
	 * 用户输入内容非法
	 */
	String ILLEGAL_USER_INPUT = "A0430";

	/**
	 * 包含违禁敏感词
	 */
	String CONTAINS_PROHIBITED_SENSITIVE_WORDS = "A0431";

	/**
	 * 图片包含违禁信息
	 */
	String THE_PICTURE_CONTAINS_PROHIBITED_INFORMATION = "A0432";

	/**
	 * 文件侵犯版权
	 */
	String DOCUMENT_INFRINGES_COPYRIGHT = "A0433";

	/**
	 * 用户操作异常
	 */
	String ABNORMAL_USER_OPERATION = "A0440";

	/**
	 * 用户支付超时
	 */
	String USER_PAYMENT_TIMEOUT = "A0441";

	/**
	 * 确认订单超时
	 */
	String ORDER_CONFIRMATION_TIMEOUT = "A0442";

	/**
	 * 订单已关闭
	 */
	String ORDER_CLOSED = "A0443";

	/**
	 * 用户请求服务异常
	 */
	String USER_REQUEST_SERVICE_EXCEPTION = "A0500";

	/**
	 * 请求次数超出限制
	 */
	String THE_NUMBER_OF_REQUESTS_EXCEEDS_THE_LIMIT = "A0501";

	/**
	 * 请求并发数超出限制
	 */
	String THE_NUMBER_OF_CONCURRENT_REQUESTS_EXCEEDS_THE_LIMIT = "A0502";

	/**
	 * 用户操作请等待
	 */
	String PLEASE_WAIT_FOR_USER_OPERATION = "A0503";

	/**
	 * WebSocket 连接异常
	 */
	String WEBSOCKET_CONNECTION_EXCEPTION = "A0504";

	/**
	 * WebSocket 连接断开
	 */
	String WEBSOCKET_CONNECTION_DISCONNECTED = "A0505";

	/**
	 * 用户重复请求
	 */
	String USER_REPEATED_REQUEST = "A0506";

	/**
	 * 用户资源异常
	 */
	String USER_RESOURCE_EXCEPTION = "A0600";

	/**
	 * 账户余额不足
	 */
	String INSUFFICIENT_ACCOUNT_BALANCE = "A0601";

	/**
	 * 用户磁盘空间不足
	 */
	String INSUFFICIENT_USER_DISK_SPACE = "A0602";

	/**
	 * 用户内存空间不足
	 */
	String INSUFFICIENT_USER_MEMORY_SPACE = "A0603";

	/**
	 * 用户 OSS 容量不足
	 */
	String INSUFFICIENT_USER_OSS_CAPACITY = "A0604";

	/**
	 * 用户配额已用光
	 */
	String USER_QUOTA_IS_USED_UP = "A0605";

	/**
	 * 用户上传文件异常
	 */
	String USER_UPLOAD_FILE_EXCEPTION = "A0700";

	/**
	 * 用户上传文件类型不匹配
	 */
	String THE_FILE_TYPE_UPLOADED_BY_THE_USER_DOES_NOT_MATCH = "A0701";

	/**
	 * 用户上传文件太大
	 */
	String THE_FILE_UPLOADED_BY_THE_USER_IS_TOO_LARGE = "A0702";

	/**
	 * 用户上传图片太大
	 */
	String THE_IMAGE_UPLOADED_BY_THE_USER_IS_TOO_LARGE = "A0703";

	/**
	 * 用户上传视频太大
	 */
	String THE_VIDEO_UPLOADED_BY_THE_USER_IS_TOO_LARGE = "A0704";

	/**
	 * 用户上传压缩文件太大
	 */
	String THE_COMPRESSED_FILE_UPLOADED_BY_THE_USER_IS_TOO_LARGE = "A0705";

	/**
	 * 用户当前版本异常
	 */
	String THE_USER_S_CURRENT_VERSION_IS_ABNORMAL = "A0800";

	/**
	 * 用户安装版本与系统不匹配
	 */
	String USER_INSTALLED_VERSION_DOES_NOT_MATCH_THE_SYSTEM = "A0801";

	/**
	 * 用户安装版本过低
	 */
	String USER_INSTALLED_VERSION_IS_TOO_LOW = "A0802";

	/**
	 * 用户安装版本过高
	 */
	String USER_INSTALLED_VERSION_IS_TOO_HIGH = "A0803";

	/**
	 * 用户安装版本已过期
	 */
	String USER_INSTALLED_VERSION_HAS_EXPIRED = "A0804";

	/**
	 * 用户API请求版本不匹配
	 */
	String USER_API_REQUEST_VERSION_MISMATCH = "A0805";

	/**
	 * 用户API请求版本过高
	 */
	String USER_API_REQUEST_VERSION_IS_TOO_HIGH = "A0806";

	/**
	 * 用户API请求版本过低
	 */
	String USER_API_REQUEST_VERSION_IS_TOO_LOW = "A0807";

	/**
	 * 用户隐私未授权
	 */
	String USER_PRIVACY_IS_NOT_AUTHORIZED = "A0900";

	/**
	 * 用户隐私未签署
	 */
	String USER_PRIVACY_IS_NOT_SIGNED = "A0901";

	/**
	 * 用户摄像头未授权
	 */
	String USER_S_CAMERA_IS_NOT_AUTHORIZED = "A0902";

	/**
	 * 用户相机未授权
	 */
	String USER_CAMERA_IS_NOT_AUTHORIZED = "A0903";

	/**
	 * 用户图片库未授权
	 */
	String USER_PICTURE_LIBRARY_IS_NOT_AUTHORIZED = "A0904";

	/**
	 * 用户文件未授权
	 */
	String USER_FILE_IS_NOT_AUTHORIZED = "A0905";

	/**
	 * 用户位置信息未授权
	 */
	String USER_LOCATION_INFORMATION_IS_NOT_AUTHORIZED = "A0906";

	/**
	 * 用户通讯录未授权
	 */
	String USER_ADDRESS_BOOK_IS_NOT_AUTHORIZED = "A0907";

	/**
	 * 用户设备异常
	 */
	String ABNORMAL_USER_EQUIPMENT = "A1000";

	/**
	 * 用户相机异常
	 */
	String USER_CAMERA_EXCEPTION = "A1001";

	/**
	 * 用户麦克风异常
	 */
	String ABNORMAL_USER_MICROPHONE = "A1002";

	/**
	 * 用户听筒异常
	 */
	String ABNORMAL_USER_HANDSET = "A1003";

	/**
	 * 用户扬声器异常
	 */
	String ABNORMAL_USER_SPEAKER = "A1004";

	/**
	 * 用户GPS定位异常
	 */
	String USER_GPS_POSITIONING_IS_ABNORMAL = "A1005";

	/**
	 * 系统执行出错
	 */
	String SYSTEM_EXECUTION_ERROR = "B0001";

	/**
	 * 系统执行超时
	 */
	String SYSTEM_EXECUTION_TIMEOUT = "B0100";

	/**
	 * 系统订单处理超时
	 */
	String SYSTEM_ORDER_PROCESSING_TIMEOUT = "B0101";

	/**
	 * 系统容灾功能被触发
	 */
	String THE_SYSTEM_DISASTER_TOLERANCE_FUNCTION_IS_TRIGGERED = "B0200";

	/**
	 * 系统限流
	 */
	String SYSTEM_CURRENT_LIMITING = "B0210";

	/**
	 * 系统功能降级
	 */
	String SYSTEM_FUNCTION_DEGRADATION = "B0220";

	/**
	 * 系统资源异常
	 */
	String SYSTEM_RESOURCE_EXCEPTION = "B0300";

	/**
	 * 系统资源耗尽
	 */
	String SYSTEM_RESOURCES_EXHAUSTED = "B0310";

	/**
	 * 系统磁盘空间耗尽
	 */
	String SYSTEM_DISK_SPACE_EXHAUSTED = "B0311";

	/**
	 * 系统内存耗尽
	 */
	String SYSTEM_MEMORY_EXHAUSTED = "B0312";

	/**
	 * 文件句柄耗尽
	 */
	String FILE_HANDLE_EXHAUSTED = "B0313";

	/**
	 * 系统连接池耗尽
	 */
	String SYSTEM_CONNECTION_POOL_EXHAUSTED = "B0314";

	/**
	 * 系统线程池耗尽
	 */
	String SYSTEM_THREAD_POOL_EXHAUSTED = "B0315";

	/**
	 * 系统资源访问异常
	 */
	String SYSTEM_RESOURCE_ACCESS_EXCEPTION = "B0320";

	/**
	 * 系统读取磁盘文件失败
	 */
	String THE_SYSTEM_FAILED_TO_READ_THE_DISK_FILE = "B0321";

	/**
	 * 调用第三方服务出错
	 */
	String ERROR_CALLING_THIRD_PARTY_SERVICE = "C0001";

	/**
	 * 中间件服务出错
	 */
	String MIDDLEWARE_SERVICE_ERROR = "C0100";

	/**
	 * RPC 服务出错
	 */
	String RPC_SERVICE_ERROR = "C0110";

	/**
	 * =RPC 服务未找到
	 */
	String RPC_SERVICE_NOT_FOUND = "C0111";

	/**
	 * RPC 服务未注册
	 */
	String RPC_SERVICE_IS_NOT_REGISTERED = "C0112";

	/**
	 * 接口不存在
	 */
	String INTERFACE_DOES_NOT_EXIST = "C0113";

	/**
	 * 消息服务出错
	 */
	String MESSAGE_SERVICE_ERROR = "C0120";

	/**
	 * 消息投递出错
	 */
	String MESSAGE_DELIVERY_ERROR = "C0121";

	/**
	 * 消息消费出错
	 */
	String MESSAGE_CONSUMPTION_ERROR = "C0122";

	/**
	 * 消息订阅出错
	 */
	String MESSAGE_SUBSCRIPTION_ERROR = "C0123";

	/**
	 * 消息分组未查到
	 */
	String MESSAGE_GROUPING_NOT_FOUND = "C0124";

	/**
	 * 缓存服务出错
	 */
	String CACHE_SERVICE_ERROR = "C0130";

	/**
	 * key 长度超过限制
	 */
	String THE_KEY_LENGTH_EXCEEDS_THE_LIMIT = "C0131";

	/**
	 * value 长度超过限制
	 */
	String THE_LENGTH_OF_VALUE_EXCEEDS_THE_LIMIT = "C0132";

	/**
	 * 存储容量已满
	 */
	String STORAGE_CAPACITY_IS_FULL = "C0133";

	/**
	 * 不支持的数据格式
	 */
	String UNSUPPORTED_DATA_FORMAT = "C0134";

	/**
	 * 配置服务出错
	 */
	String ERROR_CONFIGURING_SERVICE = "C0140";

	/**
	 * 网络资源服务出错
	 */
	String NETWORK_RESOURCE_SERVICE_ERROR = "C0150";

	/**
	 * VPN 服务出错
	 */
	String VPN_SERVICE_ERROR = "C0151";

	/**
	 * CDN 服务出错
	 */
	String CDN_SERVICE_ERROR = "C0152";

	/**
	 * 域名解析服务出错
	 */
	String DOMAIN_NAME_RESOLUTION_SERVICE_ERROR = "C0153";

	/**
	 * 网关服务出错
	 */
	String GATEWAY_SERVICE_ERROR = "C0154";

	/**
	 * 第三方系统执行超时
	 */
	String THIRD_PARTY_SYSTEM_EXECUTION_TIMEOUT = "C0200";

	/**
	 * RPC 执行超时
	 */
	String RPC_EXECUTION_TIMEOUT = "C0210";

	/**
	 * 消息投递超时
	 */
	String MESSAGE_DELIVERY_TIMEOUT = "C0220";

	/**
	 * 缓存服务超时
	 */
	String CACHE_SERVICE_TIMEOUT = "C0230";

	/**
	 * 配置服务超时
	 */
	String CONFIGURE_SERVICE_TIMEOUT = "C0240";

	/**
	 * 数据库服务超时
	 */
	String DATABASE_SERVICE_TIMEOUT = "C0250";

	/**
	 * 数据库服务出错
	 */
	String DATABASE_SERVICE_ERROR = "C0300";

	/**
	 * 表不存在
	 */
	String TABLE_DOES_NOT_EXIST = "C0311";

	/**
	 * 列不存在
	 */
	String COLUMN_DOES_NOT_EXIST = "C0312";

	/**
	 * 多表关联中存在多个相同名称的列
	 */
	String MULTIPLE_COLUMNS_WITH_THE_SAME_NAME_EXIST_IN_THE_MULTI_TABLE_ASSOCIATION = "C0321";

	/**
	 * 数据库死锁
	 */
	String DEAD_LOCK = "C0331";

	/**
	 * 主键冲突
	 */
	String PRIMARY_KEY_CONFLICT = "C0341";

	/**
	 * 第三方容灾系统被触发
	 */
	String THE_THIRD_PARTY_DISASTER_RECOVERY_SYSTEM_IS_TRIGGERED = "C0400";

	/**
	 * 第三方系统限流
	 */
	String THIRD_PARTY_SYSTEM_CURRENT_LIMIT = "C0401";

	/**
	 * 第三方功能降级
	 */
	String THIRD_PARTY_FUNCTION_DEGRADATION = "C0402";

	/**
	 * 通知服务出错
	 */
	String NOTIFICATION_SERVICE_ERROR = "C0500";

	/**
	 * 短信提醒服务失败
	 */
	String SMS_REMINDER_SERVICE_FAILED = "C0501";

	/**
	 * 语音提醒服务失败
	 */
	String VOICE_REMINDER_SERVICE_FAILED = "C0502";

	/**
	 * 邮件提醒服务失败
	 */
	String EMAIL_REMINDER_SERVICE_FAILED = "C0503";

}
