package jxf.walle.feign;

import feign.Response;
import feign.codec.ErrorDecoder;
import jxf.walle.common.result.ResultWrapper;
import jxf.walle.feign.exception.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.support.SpringDecoder;

/**
 * Feign异常解码器
 *
 * @author liao，R
 */
@Slf4j
public class FeignExceptionDecoder extends ErrorDecoder.Default {

    private final SpringDecoder decoder;

    public FeignExceptionDecoder(SpringDecoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            ResultWrapper<?> result = (ResultWrapper<?>) decoder.decode(response, ResultWrapper.class);
            return new FeignException(result.getMessage());
        } catch (Exception e) {
            // 调用方异常，状态码404，405等
            return super.decode(methodKey, response);
        }
    }
}
