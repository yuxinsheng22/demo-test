package com.yuxinsheng.demotest.test3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: yuxinsheng
 * @Date: 2019/1/10 14:43
 */
public class Test2 {
    public static void main(String[] args) {
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        System.out.println(df.format(new Date()));

    }
}
