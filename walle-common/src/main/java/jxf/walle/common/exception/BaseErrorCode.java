package jxf.walle.common.exception;


/**
 * 通用结果编码枚举
 *
 * @author liao, R
 */

public class BaseErrorCode {

    public static final ResultCode SUCCESS = new ResultCode("SUCCESS", "操作成功");
    public static final ResultCode BIZ_ERROR = new ResultCode("BIZ_ERROR", "业务处理异常");
    public static final ResultCode SYSTEM_ERROR = new ResultCode("SYSTEM_ERROR", "系统异常");
    public static final ResultCode INTERFACE_SYSTEM_ERROR = new ResultCode("INTERFACE_SYSTEM_ERROR", "外部接口调用异常");
    public static final ResultCode CONNECT_TIME_OUT = new ResultCode("CONNECT_TIME_OUT", "系统超时");
    public static final ResultCode NULL_ARGUMENT = new ResultCode("NULL_ARGUMENT", "参数为空");
    public static final ResultCode ILLEGAL_ARGUMENT = new ResultCode("ILLEGAL_ARGUMENT", "参数不合法");
    public static final ResultCode ILLEGAL_REQUEST = new ResultCode("ILLEGAL_REQUEST", "非法请求");
    public static final ResultCode METHOD_NOT_ALLOWED = new ResultCode("METHOD_NOT_ALLOWED", "请求方法不允许");
    public static final ResultCode ILLEGAL_CONFIGURATION = new ResultCode("ILLEGAL_CONFIGURATION", "配置不合法");
    public static final ResultCode ILLEGAL_STATE = new ResultCode("ILLEGAL_STATE", "状态不合法");
    public static final ResultCode ENUM_CODE_ERROR = new ResultCode("ENUM_CODE_ERROR", "错误的枚举编码");
    public static final ResultCode LOGIC_ERROR = new ResultCode("LOGIC_ERROR", "逻辑错误");
    public static final ResultCode CONCURRENT_ERROR = new ResultCode("CONCURRENT_ERROR", "并发异常");
    public static final ResultCode ILLEGAL_OPERATION = new ResultCode("ILLEGAL_OPERATION", "非法操作");
    public static final ResultCode REPETITIVE_OPERATION = new ResultCode("REPETITIVE_OPERATION", "重复操作");
    public static final ResultCode NO_OPERATE_PERMISSION = new ResultCode("NO_OPERATE_PERMISSION", "无操作权限");
    public static final ResultCode RESOURCE_NOT_FOUND = new ResultCode("RESOURCE_NOT_FOUND", "资源不存在");
    public static final ResultCode RESOURCE_ALREADY_EXIST = new ResultCode("RESOURCE_ALREADY_EXIST", "资源已存在");
    public static final ResultCode TYPE_UN_MATCH = new ResultCode("TYPE_UN_MATCH", "类型不匹配");
    public static final ResultCode FILE_NOT_EXIST = new ResultCode("FILE_NOT_EXIST", "文件不存在");
    public static final ResultCode LIMIT_BLOCK = new ResultCode("LIMIT_BLOCK", "请求限流阻断");
    public static final ResultCode TOKEN_FAIL = new ResultCode("TOKEN_FAIL", "token校验失败");
    public static final ResultCode TOKEN_EXPIRE = new ResultCode("TOKEN_EXPIRE", "token过期");
    public static final ResultCode REQUEST_EXCEPTION = new ResultCode("REQUEST_EXCEPTION", "请求异常");
    public static final ResultCode BLOCK_EXCEPTION = new ResultCode("BLOCK_EXCEPTION", "接口限流降级");
}
