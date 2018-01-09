package com.kevin.demo.swagger.web;

import com.kevin.demo.swagger.bean.Address;
import com.kevin.demo.swagger.bean.User;
import com.kevin.demo.swagger.common.Constants;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2018/1/9.
 */
@RestController
@RequestMapping(value = "/demo/user")
@Api(value = "用户Controller", tags = {"用户操作接口"})
public class UserController {

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询用户", notes = "userId必填")
    public User queryUserById(@PathVariable String userId) {
        return genUser(userId);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "查询所有用户", notes = "默认查第一页20个 用户")
    @ApiImplicitParams({@ApiImplicitParam(value = "页码", name = "page", defaultValue = "1", dataType = "Integer", required = false),
            @ApiImplicitParam(value = "页大小", name = "pageSize", defaultValue = "20", dataType = "Integer", required = false)})
    public List<User> queryUser(@RequestParam(required = false, defaultValue = "1") Integer page,
                                @RequestParam(required = false, defaultValue = "20") Integer pageSize) {
        List<User> users = new ArrayList<>();
        users.add(genUser("1"));
        users.add(genUser("2"));
        users.add(genUser("3"));
        return users;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "新增用户")
    @ApiResponses({@ApiResponse(code = Constants.OK, message = Constants.MSG_OK),
            @ApiResponse(code = Constants.ERROR, message = Constants.MSG_ERROR)})
    public User addUser(@RequestBody User user) {
        user.setUserName("Hi, " + user.getUserName());
        return user;
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation(value = "修改用户")
    public User updateUser(@RequestBody User user) {
        user.setUserName("update " + user.getUserName());
        return user;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = "application/json")
    @ApiOperation(value = "删除用户", notes = "根据userId删除")
    public Integer deleteUser(@PathVariable String userId) {
        return 1;
    }

    private User genUser(String userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName("kevin");
        user.setSex("M");
        user.setAge(18);
        Address addr = new Address();
        addr.setProvince("上海");
        addr.setCity("徐汇");
        addr.setStreet("凯滨路206号");
        addr.setPost(200000);
        List<Address> addrs = new ArrayList<>();
        addrs.add(addr);
        user.setAddresses(addrs);
        return user;
    }
}
