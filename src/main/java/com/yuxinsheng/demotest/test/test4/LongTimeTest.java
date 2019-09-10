package com.yuxinsheng.demotest.test.test4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LongTimeTest {
    public static void main(String[] args) {
        Long time = 1545815218364L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        System.out.println(sdf.format(new Date(time)));
    }
}
