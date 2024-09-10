package jxf.walle.rocketmq;


import jxf.walle.rocketmq.annotation.MessageQueueScan;
import jxf.walle.rocketmq.config.AliMqConfiguration;
import jxf.walle.rocketmq.config.OpenSourceMqConfiguration;
import jxf.walle.rocketmq.config.RocketMqConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author liao
 */
@Configuration
@MessageQueueScan("jxf.**.mq.**")
@EnableConfigurationProperties(RocketMqConfigurationProperties.class)

@Import({AliMqConfiguration.class, OpenSourceMqConfiguration.class})
public class RocketMqAutoConfiguration {

}
