package jxf.walle.web.exception;


import jxf.walle.common.exception.BaseResultCodeEnum;
import jxf.walle.common.exception.BizException;
import jxf.walle.common.result.ResultWrapper;
import jxf.walle.common.utils.SpringContextUtil;
import jxf.walle.web.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * 全局异常捕获以及错误日志管理
 * <p>
 * - 异常可以分为业务异常、程序异常，程序异常又分为前端传参异常和后端程序异常
 * - 只有程序异常需要打印error日志，配合日志采集实时跟踪程序异常
 * - 同时如果前端传参异常需要给出400响应码且明确提示错误原因，方便甩锅[dog]
 *
 * @author liao, R
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理业务异常，BizException
     */
    @ResponseBody
    @ExceptionHandler(BizException.class)
    public ResultWrapper<Void> handleException(BizException bizException) {
        log.warn("业务异常 {}", bizException.getMessage());
        return ResultWrapper.fail(bizException.getCode(), bizException.getMsg());
    }

    /**
     * 参数绑定异常（包含接口参数类型不匹配、@Valid入参校验）
     * <p>
     * 如前端传string，后端用Long接收
     * 或者@Valid注解校验不通过
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BindException.class)
    public ResultWrapper<Void> handleException(BindException e) {
        String errorMsg = e.getFieldErrors().stream()
                .map(error -> "[" + error.getField() + "]" + error.getDefaultMessage())
                .collect(Collectors.joining(","));
        log.error("接口入参异常，uri：{}，异常信息：{}", RequestUtil.getRequestInfo(), errorMsg);
        return ResultWrapper.fail(BaseResultCodeEnum.ILLEGAL_ARGUMENT, errorMsg);
    }

    /**
     * 请求不可读异常
     * 常见入参数据错误导致json反序列化异常
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResultWrapper<Void> handleException(HttpMessageNotReadableException e) {
        String rootCauseMessage = ExceptionUtils.getRootCauseMessage(e);
        log.error("接口入参异常，uri：{}，异常信息：{}", RequestUtil.getRequestInfo(), rootCauseMessage);
        return ResultWrapper.fail(BaseResultCodeEnum.ILLEGAL_ARGUMENT, rootCauseMessage);
    }

    /**
     * validate 参数校验错误异常
     * 接口入参@Validated的简单类型校验不通过
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResultWrapper<Void> handleException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        String errMsg = violations.stream()
                .map(violation -> ((PathImpl) violation.getPropertyPath()).getLeafNode().getName() + violation.getMessage())
                .collect(Collectors.joining(";"));
        log.error("参数校验异常：{}", errMsg);
        return ResultWrapper.fail(BaseResultCodeEnum.ILLEGAL_ARGUMENT, errMsg);
    }

    /**
     * validate 校验错误异常
     * 接口入参使用@Validated的对象属性校验不通过
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultWrapper<Void> exceptionHandler2(MethodArgumentNotValidException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        String errMsg = allErrors.stream().map(error -> ((FieldError) error).getField() + error.getDefaultMessage()).collect(Collectors.joining(";"));
        log.error("参数校验异常：{}", errMsg);
        return ResultWrapper.fail(BaseResultCodeEnum.ILLEGAL_ARGUMENT, errMsg);
    }

    /**
     * 参数类型不匹配
     * 如需要Integer但传入String
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResultWrapper<Void> handleException(MethodArgumentTypeMismatchException e) {
        String errorMsg = "Parameter \"" + e.getName() + "\" " + e.getMessage();
        log.error("接口入参类型异常，uri：{}，异常信息：{}", RequestUtil.getRequestInfo(), errorMsg);
        return ResultWrapper.fail(BaseResultCodeEnum.ILLEGAL_ARGUMENT, errorMsg);
    }

    /**
     * 请求方式错误
     * 如post方式请求get接口
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResultWrapper<Void> handleException(HttpRequestMethodNotSupportedException e) {
        log.error("接口请求方式错误，uri：{}，异常信息：{}", RequestUtil.getRequestInfo(), e.getMessage());
        return ResultWrapper.fail(BaseResultCodeEnum.METHOD_NOT_ALLOWED, e.getMessage());
    }

    /**
     * 其他异常（即程序异常）
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultWrapper<Void> handleException(Exception exception) {
        // 打印堆栈信息
        String exceptionMsgWithStack = getExceptionMsgWithStack(exception);
        log.error("系统异常，请排查代码或数据，\uD83D\uDD17uri：{}，ℹ异常信息：{}", RequestUtil.getRequestInfo(), exceptionMsgWithStack, exception);
        // 生产上为了安全不响应给客户端，其他环境可以返回以提高排查效率
        return ResultWrapper.fail(BaseResultCodeEnum.SYSTEM_ERROR, SpringContextUtil.isProd() ? "" : exceptionMsgWithStack);
    }

    /**
     * 分析报错位置，帮助排查问题
     */
    private String getExceptionMsgWithStack(Exception exception) {
        StringBuilder errorMsg = new StringBuilder(exception.toString());
        for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
            // 将堆栈信息中第一个业务代码的位置显示出来
            if (stackTraceElement.toString().contains("com.msb")) {
                errorMsg.append("，⚓异常定位：");
                errorMsg.append(stackTraceElement);
                break;
            }
        }
        return errorMsg.toString();
    }

}
