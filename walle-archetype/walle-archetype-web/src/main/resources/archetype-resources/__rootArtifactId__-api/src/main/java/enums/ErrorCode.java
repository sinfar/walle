#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )

package ${package}.enums;

import com.isay.starter.base.BaseError;

/**
 * 错误码枚举类
 *
 * @author Axe
 * @date 2020/6/9
 */
public enum ErrorCode implements BaseError {

	/**
	 * 找不到用户信息,demo可删除
	 */
	USER_NOT_FOUND("10001", "找不到信息"),

	;

	/**
	 * 返回码
	 */
	private String errorCode;
	/**
	 * 返回信息
	 */
	private String errorMsg;

	ErrorCode(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	@Override
	public String getErrorCode() {
		return errorCode;
	}

	@Override
	public String getErrorMsg() {
		return errorMsg;
	}

}
