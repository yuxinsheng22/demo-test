package com.yuxinsheng.demotest.test.test3;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

    public void getThreadId() {
        System.out.println(Thread.currentThread().getId());
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPools = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
        for (int i = 0; i < 10; i++) {
            threadPools.execute(() -> {
                try {
//                    countDownLatchTest.getThreadId();
                    for (int j = 0; j < 5; j++) {
                        System.out.println(j);
                    }
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println(new Date());
    }
}
