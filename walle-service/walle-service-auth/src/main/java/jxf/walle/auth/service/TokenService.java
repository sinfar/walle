package jxf.walle.auth.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Map;

/**
 * @author Axe
 * @date 2020/11/27
 * @description
 */
@Slf4j
@Service
public class TokenService {


    @Lazy
    @Autowired
    private TokenEndpoint tokenEndpoint;


    public OAuth2AccessToken login(Principal principal, Map<String, String> param)
        throws Exception {

        // 调用获取Token流程
        OAuth2AccessToken auth2AccessToken = tokenEndpoint.postAccessToken(principal, param)
            .getBody();


        return auth2AccessToken;
    }


}
