package jxf.walle.rocketmq.annotation;


import jxf.walle.rocketmq.spring.MessageQueueRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liao
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MessageQueueRegistrar.class)
public @interface MessageQueueScan {

    String [] value();
}
