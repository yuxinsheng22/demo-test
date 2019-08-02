package com.yuxinsheng.demotest.test2;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: yuxinsheng
 * @Date: 2018/11/26 09:47
 */
public class Test4 {

    public static void main(String[] args) {
        Long from = 1532275200000L;
        Long to = 1540828800000L;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateFrom = new Date(from);
        Date dateTo = new Date(to);
        System.out.println(format.format(dateFrom));
        System.out.println(format.format(dateTo));
        Date dateToAddOne = new DateTime(dateTo).plusDays(1).toDate();
        System.out.println(format.format(dateToAddOne));
        System.out.println(dateToAddOne.getTime());
    }
}
