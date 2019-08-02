package com.yuxinsheng.demotest.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class User {

    private String userName;

    private Integer age;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date jackson;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date myDate;


    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }
}
