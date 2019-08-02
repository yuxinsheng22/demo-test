package com.yuxinsheng.demotest.bean;

import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class BeanTest {
    public static void main(String[] args) {
        Bean1 bean1 = new Bean1(1L,"小明",new Date());
        Bean2 bean2 = new Bean2();
        BeanUtils.copyProperties(bean1,bean2);
        System.out.println(new Gson().toJson(bean1));
        System.out.println(new Gson().toJson(bean2));
    }
}
