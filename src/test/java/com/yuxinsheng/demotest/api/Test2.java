package com.yuxinsheng.demotest.api;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/28 16:15
 */
public class Test2 {

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Test
    public void test() {
        int i = 1;
        int j = 100;
        while (i <= j) {
            System.out.println("主线程" + i);
            int finalI = i;
            executorService.execute(() -> function(finalI));
            executorService.execute(() -> System.out.println("-----exec" + finalI));
            i++;
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }
        System.out.println("complete!");
    }

    public void function(int i) {
        if (i % 2 == 0) {
            try {
                executorService.awaitTermination(2, SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
