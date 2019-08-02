package com.yuxinsheng.demotest.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public static String format(long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static void main(String[] args) {
        long time = 1557807266000L;
        System.out.println(format(time));

    }
}
