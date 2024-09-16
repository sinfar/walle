package jxf.walle.web.result;


import jxf.walle.common.exception.BaseErrorCode;
import jxf.walle.common.exception.BizException;
import jxf.walle.common.exception.ResultCode;

import java.util.Collection;
import java.util.Objects;

/**
 * @author liao
 */
public class BizAssert {

    private BizAssert() {
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BizException(BaseErrorCode.BIZ_ERROR.getCode(), message);
        }
    }

    public static void notTrue(boolean expression, String message) {
        if (expression) {
            throw new BizException(BaseErrorCode.BIZ_ERROR.getCode(), message);
        }
    }

    public static void isNull(Object object, String message) {
        if (!Objects.isNull(object)) {
            throw new BizException(BaseErrorCode.BIZ_ERROR.getCode(), message);
        }
    }

    public static void notNull(Object object, String message) {
        if (Objects.isNull(object)) {
            throw new BizException(BaseErrorCode.BIZ_ERROR.getCode(), message);
        }
    }

    public static void notNull(Object object, ResultCode resultCode) {
        if (Objects.isNull(object)) {
            throw new BizException(resultCode);
        }
    }

    public static void isEmpty(Collection<?> collection, String message) {
        if (!Objects.isNull(collection) && !collection.isEmpty()) {
            throw new BizException(BaseErrorCode.BIZ_ERROR.getCode(), message);
        }
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (Objects.isNull(collection) || collection.isEmpty()) {
            throw new BizException(BaseErrorCode.BIZ_ERROR.getCode(), message);
        }
    }

}
