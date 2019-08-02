package com.yuxinsheng.demotest.controller;

import com.yuxinsheng.demotest.test3.TestDomain;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yuxinsheng
 * @Date: 2019/1/10 14:47
 */
@RestController
public class TestController6 {

    @RequestMapping("/demo/test/domain")
    public TestDomain test() {
        return new TestDomain();
    }
}
