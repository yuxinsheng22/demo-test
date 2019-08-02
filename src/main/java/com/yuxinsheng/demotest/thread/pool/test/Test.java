package com.yuxinsheng.demotest.thread.pool.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            int poolSize = 10;

            //1 新增一些TracingObject
            List<TracingObject> objects = new ArrayList<TracingObject>();

            for (int i = 1; i <= 10; i++) {
                objects.add(new TracingObject(new Integer(i), "file_name_" + i, "content_" + i, "description_" + i, new Integer(1)));
            }

            for (int i = 1; i <= 10; i++) {
                objects.add(new TracingObject(new Integer(i), "maintainlog_name_" + i, "content_" + i, "description_" + i, new Integer(2)));
            }

            for (int i = 1; i <= 10; i++) {
                objects.add(new TracingObject(new Integer(i), "db_name_" + i, "content_" + i, "description_" + i, new Integer(3)));
            }

            //2 创建线程池
            TracingThreadPool tracingThreadPool = new TracingThreadPool(poolSize);

            //3 新增一些任务到线程池中 给线程执行
            for (TracingObject tracingObject : objects) {
                tracingThreadPool.addTask(new TracingTask(tracingObject));
            }

            //4 等待工作线程完成所有的任务
            tracingThreadPool.join();

            //5 关闭线程池
            tracingThreadPool.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
