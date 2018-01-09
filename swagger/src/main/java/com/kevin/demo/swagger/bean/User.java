package com.kevin.demo.swagger.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by Kevin on 2018/1/9.
 */
@ApiModel(value = "用户信息", description = "userName不能为空")
public class User {
    @ApiModelProperty(value = "用户ID", name = "userId")
    private String userId;
    @ApiModelProperty(value = "用户名称", name = "userName", required = true)
    private String userName;
    @ApiModelProperty(value = "用户性别", name = "sex", allowableValues = "F,M", example = "F")
    private String sex;
    @ApiModelProperty(value = "用户年龄", name = "age", dataType = "Integer")
    private Integer age;
    @ApiModelProperty(value = "用户地址列表", name = "addresses", notes = "一个用户可以有多个地址")
    private List<Address> addresses;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", addresses=" + addresses +
                '}';
    }
}
