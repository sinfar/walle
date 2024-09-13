package jxf.walle.gateway.config;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;

/**
 * @author: Simon
 * @Data:2024/9/13
 */
@Configuration
public class SecurityConfig {
    private final DiscoveryClient discoveryClient;

    public SecurityConfig(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Bean
    public ReactiveJwtDecoder jwtDecoder() {
        // 动态从服务注册中心获取 JWK 公钥的 URI
        String jwkSetUri = getJwkUriFromService("auth"); // 使用服务名获取 JWK 公钥
        return new NimbusReactiveJwtDecoder(jwkSetUri);
    }

    private String getJwkUriFromService(String serviceName) {
        // 假设使用 Eureka 或其他服务发现工具来获取服务实例的 URL
        return discoveryClient.getInstances(serviceName)
                .stream()
                .findFirst()
                .map(serviceInstance -> serviceInstance.getUri().toString() + "/rsa/publicKey")
                .orElseThrow(() -> new RuntimeException("Service not found: " + serviceName));
    }
}
