package com.yuxinsheng.demotest.controller;

import com.yuxinsheng.demotest.controller.response.StudentDate;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: yuxinsheng
 * @Date: 2019/1/4 10:17
 */
@RestController
public class TestController3 {

    @RequestMapping("/demo/test/date")
    public StudentDate test() {
        StudentDate studentDate = new StudentDate();
        studentDate.setName("小明");
        studentDate.setFrom(new Date());
        studentDate.setTo(new DateTime().plusDays(1).toDate());
        return studentDate;
    }
}
