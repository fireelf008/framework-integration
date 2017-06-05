package com.wsf.pojo.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户entity
 */
public class User implements Serializable {

    @ApiModelProperty(value = "用户id")
    private Integer id;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
