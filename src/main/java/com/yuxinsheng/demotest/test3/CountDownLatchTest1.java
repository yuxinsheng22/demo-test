package com.yuxinsheng.demotest.test3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest1 {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch startCdl = new CountDownLatch(1);
        final CountDownLatch endCdl = new CountDownLatch(10);
        ExecutorService threadPools = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            threadPools.execute(() -> {
                try {
                    startCdl.await();
                    try {
                        Thread.sleep(10);
                    } finally {
                        endCdl.countDown();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        long start = System.currentTimeMillis();
        System.out.println(start);
        startCdl.countDown();
        endCdl.await();
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("耗时:" + (end - start));
    }
}
