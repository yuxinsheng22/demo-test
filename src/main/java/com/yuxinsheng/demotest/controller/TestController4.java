package com.yuxinsheng.demotest.controller;

import com.yuxinsheng.demotest.service.TestService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yuxinsheng
 * @Date: 2019/1/7 17:06
 */
@RestController
public class TestController4 {

    @Autowired
    private TestService2 service2;

    @RequestMapping("/demo/test4")
    public String test4(){
        return service2.test();
    }
}
