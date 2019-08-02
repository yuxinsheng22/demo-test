package com.yuxinsheng.demotest.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchServer2 {

    public static void handle1() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("handle1执行...");
    }

    public static void handle2() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("handle2执行...");
    }


    public static void handle3() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("handle3执行...");
    }

    public static void test() {
        long start = System.currentTimeMillis();
        CountDownLatch cdl = new CountDownLatch(3);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(() -> {
            try {
                handle1();
                cdl.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.execute(() -> {
            try {
                handle2();
                cdl.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.execute(() -> {
            try {
                handle3();
                cdl.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            cdl.await();
            pool.shutdown();
            long end = System.currentTimeMillis();
            System.out.println("执行结束:执行时间" + (end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test();
    }

}
