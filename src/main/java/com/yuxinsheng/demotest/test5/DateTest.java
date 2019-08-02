package com.yuxinsheng.demotest.test5;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        Date createdDate = java.util.Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(createdDate);
        System.out.println(new Date(1557029420000L));

    }
}
