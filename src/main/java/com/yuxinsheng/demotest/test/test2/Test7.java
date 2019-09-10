package com.yuxinsheng.demotest.test.test2;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: yuxinsheng
 * @Date: 2018/11/30 15:54
 */
public class Test7 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date from = format.parse("2017-11-26 12:00:00");
        Date to = format.parse("2018-11-26 15:00:00");
        int dayFrom = new DateTime(from).dayOfYear().get();
        int yearFrom = new DateTime(from).getYear();
        int dayTo = new DateTime(to).dayOfYear().get();
        System.out.println(dayFrom);
        System.out.println(dayTo);
        System.out.println(yearFrom);
    }
}
