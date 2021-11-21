package com.example.demo.model;

import javax.annotation.Generated;

public class User {
    /**
     */
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer uid;

    /**
     */
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String uname;

    /**
     */
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String upwd;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getUid() {
        return uid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUname() {
        return uname;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUname(String uname) {
        this.uname = uname;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUpwd() {
        return upwd;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}