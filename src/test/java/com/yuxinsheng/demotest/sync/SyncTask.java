package com.yuxinsheng.demotest.sync;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/29 11:18
 */
public class SyncTask {

    public void task(final MyCallback myCallback){
        Thread thread=new Thread(() -> {
            try {
                //线程睡眠3秒，模拟该线程执行时间过长，也就是上面说的【B口有东西塞住】
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //完成0到99的累加
            int sum=0;
            for(int i=0;i<100;i++){
                sum+=i;
            }
            //将结果交给接口的实现类取处理
            myCallback.callback(sum);
        });
        //启动线程
        thread.start();
    }

}
