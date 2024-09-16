package jxf.walle.common.exception;

/**
 * @author liao
 */
public class BizException extends RuntimeException {
    private final String code;
    private final String msg;

    public BizException(ResultCode resultCode) {
        super(resultCode.getCode() + resultCode.getMessage());
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
    }

    public BizException(String code, String message) {
        super(code + message);
        this.code = code;
        this.msg = message;
    }

    public BizException(String message) {
        super(message);
        this.code = BaseErrorCode.BIZ_ERROR.getCode();
        this.msg = message;
    }


    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
