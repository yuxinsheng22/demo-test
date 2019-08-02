package com.yuxinsheng.demotest.sync;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/17 12:28
 */
public class Test1 {


    public static void main(String[] args) {
        System.out.println("start...");
        new Thread(() -> {
            System.out.println("新开线程。。。");
            try {
                Thread.sleep(5000);
                System.out.println("已经睡醒。。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("结束。。。");
    }
}
