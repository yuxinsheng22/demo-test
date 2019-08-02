package com.yuxinsheng.demotest.thread.pool.test;

public class TracingTask implements Runnable {
    private TracingObject tracingObject;

    private TracingTask() {}

    public TracingTask(TracingObject tracingObject) {
        this.tracingObject = tracingObject;
    }


    public void run() {
        // TODO Auto-generated method stub
        try {
            System.out.println(Thread.currentThread().getName() + "\t" + this.tracingObject);
            // 增加执行一个任务的时间,3秒
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }
    }
}
