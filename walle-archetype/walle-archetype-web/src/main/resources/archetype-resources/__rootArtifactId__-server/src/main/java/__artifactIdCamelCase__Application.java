#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package};
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 *
 * @author Axe
 * @since 2020-06-08
 */
@SpringBootApplication
@MapperScan("${package}.mapper")
public class ${artifactIdCamelCase}Application {

	public static void main(String[] args) {
		SpringApplication.run(${artifactIdCamelCase}Application.class);
	}

}
