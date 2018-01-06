package com.kevin.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kevin on 2018/1/6.
 */
@RestController
@Api(value = "HELLO WORLD", description = "Swagger")
public class HiController {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hi", method = {RequestMethod.GET,RequestMethod.POST})
    @ApiOperation(value = "hello world")
    public String home(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }
}
