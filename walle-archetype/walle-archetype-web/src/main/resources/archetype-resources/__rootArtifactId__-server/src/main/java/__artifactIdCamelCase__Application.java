#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' ) 
package ${package};
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * 项目启动类
 *
 * @author Axe
 * @since 2020-06-08
 */
@SpringBootApplication
@MapperScan("com.isay.**.mapper")
public class ${artifactIdCamelCase}Application {

	public static void main(String[] args) {
		SpringApplication.run(${artifactIdCamelCase}Application.class);
	}


	/**
	 * prometheus
	 */
	@Bean
	MeterRegistryCustomizer<MeterRegistry> configurer(
		@Value("${spring.application.name}") String applicationName) {
		return (registry) -> registry.config().commonTags("application", applicationName);
	}

}
