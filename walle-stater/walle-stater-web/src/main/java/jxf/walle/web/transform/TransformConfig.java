package jxf.walle.web.transform;

import jxf.walle.web.transform.transformer.EnumTransformer;
import jxf.walle.web.transform.unwrapper.PageUnWrapper;
import jxf.walle.web.transform.unwrapper.ResultUnWrapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 转换器配置类
 * 约定自定义转换器都放在api包的transformer目录下，方便给其他模块使用
 *
 * @author R
 */
@Configuration
@ComponentScan("jxf.**.transformer")
@Import({EnumTransformer.class, PageUnWrapper.class, ResultUnWrapper.class})
public class TransformConfig {


}
