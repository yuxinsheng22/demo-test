package com.yuxinsheng.demotest.controller;

import com.google.common.collect.Maps;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/29 10:15
 */
@RestController
public class TestControlller2 {

    private static Map<String, String> map = Maps.newConcurrentMap();

    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    @RequestMapping("/demo/test")
    public String test() {
//        executorService.execute(() -> {
//            f();
//            System.out.println("wait after");
//        });
        Thread thread = new Thread(() -> {
            f();
            System.out.println("wait after");
        });
        thread.start();
        return "hello";
    }

    public void f() {
        try {
            Thread.sleep(5*1000);
            map.put("hello", "world");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("demo/test2")
    public String test2(String string) {
        return map.get(string);
    }

}
