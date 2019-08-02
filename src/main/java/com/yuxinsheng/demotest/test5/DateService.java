package com.yuxinsheng.demotest.test5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateService {
    public static void main(String[] args) {
        Long time = 1562083200000L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date(time)));

    }
}
