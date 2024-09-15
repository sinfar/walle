#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\')
#set($symbol_jwt='${jwt.publicKey:}')
package ${package}.config;

import com.isay.starter.security.BaseResourcesConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author Axe
 * @date 2020/11/12
 * @description 资源服务权限校验
 */
@Slf4j
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class AuthConfig extends BaseResourcesConfig {

	@Value("$symbol_jwt")
	private String publicKey;

	@Override
	public String getPublicKey() {
		return publicKey;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.authorizeRequests()
			.antMatchers("/api/**").authenticated();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		super.configure(resources);
	}

}