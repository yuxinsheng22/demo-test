package com.yuxinsheng.demotest.test2;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/18 09:31
 */
public class Test13 {
    public static void main(String[] args) {

        Date now = new DateTime(new Date()).withTimeAtStartOfDay().toDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
        System.out.println(format.format(now));
    }
}
