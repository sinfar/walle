package jxf.walle.auth.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * SpringSecurity配置
 * Created by macro on 2020/6/19.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 允许访问 Spring Boot Actuator 的所有端点
                .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
                // 允许访问 RSA 公钥的接口
                .antMatchers("/rsa/publicKey").permitAll()
                // 允许访问 Knife4j 的所有相关路径
                .antMatchers(
                        "/doc.html",           // Knife4j 文档页面
                        "/v2/api-docs",        // Swagger 2.0 API 文档
                        "/v3/api-docs/**",     // OpenAPI 3.0 API 文档
                        "/swagger-resources/**",
                        "/swagger-ui/**",      // Swagger UI 静态资源
                        "/webjars/**"          // 静态资源
                ).permitAll()
                .anyRequest().authenticated();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
