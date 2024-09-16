package jxf.walle.common.exception;

/**
 * @author liao
 */
public class ResultCode {
    private String code;
    private String message;

    public ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
