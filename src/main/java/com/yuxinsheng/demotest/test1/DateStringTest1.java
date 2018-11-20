package com.yuxinsheng.demotest.test1;

import org.joda.time.DateTime;

/**
 * @author yuxinsheng
 * @date 2018/10/30 14:15
 */
public class DateStringTest1 {
    public static void main(String[] args) {
        DateTime dateTime1 = new DateTime("2018-08-05");
        System.out.println(dateTime1.toString("yyyy-MM-dd"));
    }
}
