package com.yuxinsheng.demotest.test.test2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/14 13:55
 */
public class Test12 {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long time = 1544630400000L;
        System.out.println(format.format(new Date(time)));
    }
}
