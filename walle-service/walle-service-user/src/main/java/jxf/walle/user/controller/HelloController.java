package jxf.walle.user.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 * Created by macro on 2020/6/19.
 */
@RestController
@Api
public class HelloController {

    @GetMapping("/hello")
    @ApiOperation("hello")
    public String hello() {
        return "Hello World.";
    }

}
