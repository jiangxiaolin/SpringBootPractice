package cn.netrookie.common;

public class Result {

	/** 00:SUCCESS */
	private Integer code;
	private Object msg;

	/**
	 * 构造Test对象
	 * 
	 * @return
	 */
	public static Result toDefault() {
		Result result = new Result();
		result.setCode(Constant.RESULT_RET_SUCCESS);
		return result;
	}

	public Result() {
		super();
	}

	/**
	 * 将状态代码设置为失败
	 */
	public void failed() {
		this.code = Constant.RESULT_RET_FAILED;
	}

	/**
	 * 将状态设置为失败,并且将错误信息写入msg
	 * 
	 * @param msg
	 */
	public void failed(String msg) {
		failed(Constant.RESULT_RET_FAILED, msg);
	}

	/**
	 * 设置code和msg
	 * 
	 * @param code
	 * @param msg
	 */
	public void failed(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Result(Integer code) {
		super();
		this.code = code;
	}

	/**
	 * 判断是否是正确的
	 * 
	 * @return
	 */
	public boolean success() {
		return Constant.RESULT_RET_SUCCESS.equals(code);
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return String.format(
				"{\"success\":\"%s\",\"code\":\"%s\",\"msg\":\"%s\"}",
				success(), code, msg);
	}
	
	public String toOpString() {
		return String.format(
				"{\"code\":\"%s\",\"msg\":\"%s\"}",
				code, msg);
	}

}
