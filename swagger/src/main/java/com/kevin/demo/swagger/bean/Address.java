package com.kevin.demo.swagger.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Kevin on 2018/1/9.
 */
@ApiModel(value = "地址", description = "省、市、街道、邮编")
public class Address {
    @ApiModelProperty(value = "省", name = "province")
    private String province;
    private String city;
    private Integer post;
    private String street;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", post=" + post +
                ", street='" + street + '\'' +
                '}';
    }
}
