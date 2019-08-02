package com.yuxinsheng.demotest.service;

import com.yuxinsheng.demotest.util.TestServiceHelper;
import org.springframework.stereotype.Service;

/**
 * @Author: yuxinsheng
 * @Date: 2019/1/7 17:02
 */
@Service
public class TestService2 {

    public String test() {
        return TestServiceHelper.get();
    }
}
