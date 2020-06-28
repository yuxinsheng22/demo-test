package com.yuxinsheng.demotest.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yuxinsheng
 * @date 2020/6/28 12:01
 */
@Slf4j
public class TemplateTest {

    public static void main(String[] args) {
        String name = "张三";
        test(name);
    }

    public static void test(String name) {
        log.info("来了,{}", name);
    }
}
