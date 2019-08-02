package com.yuxinsheng.demotest.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/28 15:40
 */
@Slf4j
public class Test1 {

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Test
    public void test() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("result" + i);
            function(i);
            int finalI = i;
            executorService.execute(() -> System.out.println(finalI));
        }
    }

    public void function(int i) {
        if (i % 10 == 0) {
            try {
                executorService.awaitTermination(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
