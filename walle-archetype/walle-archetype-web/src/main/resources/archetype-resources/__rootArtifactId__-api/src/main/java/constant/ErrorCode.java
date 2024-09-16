#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.constant;

import jxf.walle.common.exception.BaseErrorCode;
import jxf.walle.common.exception.ResultCode;

/**
 * 错误码定义集合，已继承公共错误码
 * @author: Simon
 * @Data:2024/9/16
 */
public class ErrorCode extends BaseErrorCode {
    // 示例
    public static final ResultCode DEMO = new ResultCode("ERROR_CODE", "错误描述");
}
