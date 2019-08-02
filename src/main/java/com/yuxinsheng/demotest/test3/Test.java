package com.yuxinsheng.demotest.test3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: yuxinsheng
 * @Date: 2019/1/8 11:23
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        String date = "2016-08-15T16:00:00.000Z";
        date = date.replace("Z", " UTC");
        System.out.println(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date d = format.parse(date);
        System.out.println(d);
    }

}
