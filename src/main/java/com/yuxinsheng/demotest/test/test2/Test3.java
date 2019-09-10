package com.yuxinsheng.demotest.test.test2;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * @Author: yuxinsheng
 * @Date: 2018/11/21 2:09 PM
 */
public class Test3 {

    public static void main(String[] args) {
        System.out.println(new DateTime(new Date()).toString());
        System.out.println(new Date().toString());
    }
}
