package jxf.walle.web;

import jxf.walle.web.config.DateTimeConfig;
import jxf.walle.web.config.DateTimeConvertPrimaryConfig;
import jxf.walle.web.exception.GlobalExceptionHandler;
import jxf.walle.web.exception.SentinelBlockExceptionHandler;
import jxf.walle.web.result.InitializingAdviceDecorator;
import jxf.walle.web.swagger.SwaggerConfiguration;
import jxf.walle.web.swagger.SwaggerShortcutController;
import jxf.walle.web.transform.TransformConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author liao
 */
@Configuration
@ComponentScan(basePackages = "jxf.walle.web")
@Import({SwaggerConfiguration.class, InitializingAdviceDecorator.class,
        GlobalExceptionHandler.class, SentinelBlockExceptionHandler.class,
        DateTimeConfig.class, SwaggerShortcutController.class, TransformConfig.class, DateTimeConvertPrimaryConfig.class})
public class WebAutoConfig {

}
