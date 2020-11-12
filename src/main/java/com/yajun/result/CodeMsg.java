package com.yajun.result;

public class CodeMsg {
	
	private int code;
	private String msg;
	
	//通用的错误码
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
	public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
	public static CodeMsg REQUEST_ILLEGAL = new CodeMsg(500102, "请求非法");
	public static CodeMsg ACCESS_LIMIT_REACHED= new CodeMsg(500104, "访问太频繁！");
	public static CodeMsg CHECK_VERIFY_CODE_FAIL = new CodeMsg(500105, "验证码验证失败");
	public static CodeMsg PARAM_EMPTY = new CodeMsg(500106, "参数不能为空");
	public static CodeMsg REQUEST_INVALID = new CodeMsg(500106, "无效请求");
	public static CodeMsg ERROR = new CodeMsg(500107, "%s");

	//登录模块 5002XX
	public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
	public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
	public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
	public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
	public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
	public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");

	//文件上传 5003XX
	public static CodeMsg FILE_EMPTY = new CodeMsg(500300, "上传文件不能为空");
	public static CodeMsg SAVE_FILE_ERROR = new CodeMsg(500300, "保存文件失败");
	
	//用户模块 5004XX
	public static CodeMsg USER_EMPTY = new CodeMsg(500300, "用户为空");

	//二手车信息模块 5005XX
	public static CodeMsg ADDRESS_EMPTY = new CodeMsg(500500, "所在地为空");
	public static CodeMsg FORMALITIES_TIME_EMPTY = new CodeMsg(500501, "上牌时间为空");
	public static CodeMsg MILEAGE_EMPTY = new CodeMsg(500502, "行驶里程为空");
	public static CodeMsg PRICE_EMPTY = new CodeMsg(500503, "指导价格为空");
	public static CodeMsg PHOTO1_EMPTY = new CodeMsg(500504, "前照片为空");
	public static CodeMsg PHOTO2_EMPTY = new CodeMsg(500505, "后照片为空");
	public static CodeMsg PHOTO3_EMPTY = new CodeMsg(500506, "左侧45度照片为空");
	public static CodeMsg PHOTO4_EMPTY = new CodeMsg(500507, "右侧45度照片为空");
	public static CodeMsg CUSTOMER_MANAGER_NAME_EMPTY = new CodeMsg(500508, "客户经理名称为空");
	public static CodeMsg CUSTOMER_MANAGER_MOBILE_EMPTY = new CodeMsg(500509, "客户经理手机号为空");
	public static CodeMsg ADDRESS_ERROR = new CodeMsg(500510, "所在地错误");

	//申请表模块 5006XX
	public static CodeMsg ADDRESS_APPLY_EMPTY = new CodeMsg(500600, "所在地为空");
	public static CodeMsg USER_NAME_EMPTY = new CodeMsg(500601, "姓名为空");
	public static CodeMsg BRAND_EMPTY = new CodeMsg(500602, "品牌为空");
	public static CodeMsg CONTACT_MOBILE_EMPTY = new CodeMsg(500603, "联系电话为空");
	public static CodeMsg IDENTITY_FRONT_IMAGE_EMPTY = new CodeMsg(500604, "身份证正面照片为空");
	public static CodeMsg IDENTITY_REVERSE_IMAGE_EMPTY = new CodeMsg(500605, "身份证反面照片为空");

	//订单模块  5007XX
	public static CodeMsg ORDERS_EMPTY = new CodeMsg(500600, "订单不存在");
	public static CodeMsg ORDERS_NO_PAY_STATUS = new CodeMsg(500601, "订单非支付状态");
	
	private CodeMsg( ) {
	}
			
	private CodeMsg( int code,String msg ) {
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public CodeMsg fillArgs(Object... args) {
		int code = this.code;
		String message = String.format(this.msg, args);
		return new CodeMsg(code, message);
	}

	@Override
	public String toString() {
		return "CodeMsg [code=" + code + ", msg=" + msg + "]";
	}
	
	
}
