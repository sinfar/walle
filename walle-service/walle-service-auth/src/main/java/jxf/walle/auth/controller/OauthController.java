package jxf.walle.auth.controller;

import io.swagger.annotations.ApiOperation;
import jxf.walle.auth.service.TokenService;
import jxf.walle.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

/**
 * @author Axe
 * @date 2020/11/16
 * @description oauth相关的接口
 */
@Slf4j
@RestController
@RequestMapping("/oauth")
public class OauthController {
    @Autowired
    private TokenService tokenService;

    /**
     * 封装security的授权接口，自定义返回格式
     *
     * @param principal 当前用户
     * @param param
     * @return
     * @throws HttpRequestMethodNotSupportedException
     */
    @ApiOperation("登录")
    @PostMapping("/token")
    @ResponseBody
    public OAuth2AccessToken auth(Principal principal, @RequestParam Map<String, String> param) throws Exception {
        return tokenService.login(principal, param);
    }




}
