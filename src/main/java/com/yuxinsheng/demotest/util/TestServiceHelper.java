package com.yuxinsheng.demotest.util;

import com.yuxinsheng.demotest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: yuxinsheng
 * @Date: 2019/1/7 17:01
 */
public class TestServiceHelper {

    @Autowired
    private static TestService service;

    public static String get() {
        return service.test();
    }


}
