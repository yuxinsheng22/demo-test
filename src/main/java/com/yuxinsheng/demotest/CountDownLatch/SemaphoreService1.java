package com.yuxinsheng.demotest.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SemaphoreService1 {

    public static int clientTotal = 10;

    public static int threadTotal = 2;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch cdl = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            pool.execute(() -> {
                try {
                    semaphore.acquire(2);
                    transact(count);
                    semaphore.release(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    cdl.countDown();
                }
            });
        }
        try {
            cdl.await();
            pool.shutdown();
            System.out.println("今天业务办理结束...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void transact(int count) {
        System.out.println(count + "号办理业务中...");
        try {
            SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
