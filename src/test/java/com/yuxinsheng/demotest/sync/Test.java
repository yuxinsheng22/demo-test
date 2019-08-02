package com.yuxinsheng.demotest.sync;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/29 11:19
 */
public class Test {
    public static void main(String[] args) {
        //调用异步任务
        new SyncTask().task(new MyCallback() {
            //实现回调方法
            @Override
            public void callback(Object object) {
                System.out.println("异步回调处理：值 "+object);
            }
        });
        System.out.println("主线程等待异步输出");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
