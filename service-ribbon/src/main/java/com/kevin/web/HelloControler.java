package com.kevin.web;

import com.kevin.bean.User;
import com.kevin.service.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Kevin on 2018/1/2.
 */
@RestController
@Api(value = "UserInfo", description = "Swagger测试Controller")
public class HelloControler {

    @Autowired
    HelloService helloService;

    @ApiOperation(value = "hello word", notes = "hello note")
    @RequestMapping(value = "/hi",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }

    @ApiOperation(value = "查询用户", notes = "根据ID查询")
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public User queryUser(@PathVariable String id) {
        User user = new User();
        user.setSex(id);
        user.setName("welcome kevin");
        return user;
    }

    @ApiOperation(value = "新增用户", notes = "一个用户只能新增一次")
//    @ApiImplicitParams({@ApiImplicitParam(value = "名字",name = "name",required = true),
//            @ApiImplicitParam(name = "age", value = "年龄", required = true,dataType = "int")})
    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public User addUser(@RequestBody User user) {
        user.setName("add " + user.getName());
        return user;
    }
}
