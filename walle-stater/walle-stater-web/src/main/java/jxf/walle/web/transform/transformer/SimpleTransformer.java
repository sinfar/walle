package jxf.walle.web.transform.transformer;

import jxf.walle.web.transform.annotation.Transform;
import org.springframework.lang.NonNull;


/**
 * 建议转换器接口
 *
 * @author R
 */
public interface SimpleTransformer<T> extends Transformer<T, Transform> {
    /**
     * 翻译
     *
     * @param originalValue 转换之前的原始值
     * @param transform     转换注解
     * @return 翻译后的值
     */
    @Override
    default String transform(@NonNull T originalValue, Transform transform) {
        return transform(originalValue);
    }

    /**
     * 翻译
     *
     * @param originalValue 原始值
     * @return 翻译后的值
     */
    String transform(@NonNull T originalValue);


}
