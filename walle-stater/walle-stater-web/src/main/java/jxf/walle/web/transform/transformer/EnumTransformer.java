package jxf.walle.web.transform.transformer;


import jxf.walle.common.model.IDict;
import jxf.walle.web.transform.annotation.TransformEnum;

import javax.annotation.Nonnull;


/**
 * 枚举转换器
 *
 * @author R
 */
public class EnumTransformer<T> implements Transformer<T, TransformEnum> {

    @Override
    @SuppressWarnings("unchecked")
    public String transform(@Nonnull T enumCode, @Nonnull TransformEnum annotation) {
        return IDict.getTextByCode((Class<? extends IDict<T>>) annotation.value(), enumCode);
    }


}
