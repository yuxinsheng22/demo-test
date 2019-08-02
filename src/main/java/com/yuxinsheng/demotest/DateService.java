package com.yuxinsheng.demotest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateService {
    public static void main(String[] args) throws ParseException {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowStr = sdf.format(now);
        Date nowDate = sdf.parse(nowStr);

        System.out.println(now);
        System.out.println(nowDate);
    }
}
