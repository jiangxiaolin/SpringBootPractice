package cn.netrookie.common;

/**
 * 全局常量
 * 
 * @author user
 * 
 */
public class Constant {

	/** 成功 */
	public static final Integer RESULT_RET_SUCCESS = 200;
	/** 失败 */
	public static final Integer RESULT_RET_FAILED = 201;
	/** accessToken已过期 */
	public static final Integer RESULT_RET_ACCESS_TOKEN_EXPIRES = 401;
	/**请求参数不齐全*/
	public static final Integer RESULT_RET_REQUEST_NOT_COMPLETE =501;

	/** 设备唯一标识 */
	public static final String PARAMS_NAME_DEVICE_ID = "deviceId";
	/** 客户端操作系统 */
	public static final String PARAMS_NAME_CLIENT_OS_TYPE = "clientOsType";
	/** Unix毫秒数时间戳 */
	public static final String PARAMS_NAME_TIMESTAMP = "timestamp";
	/** 访问令牌 */
	public static final String PARAMS_NAME_ACCESS_TOKEN = "accessToken";

}
