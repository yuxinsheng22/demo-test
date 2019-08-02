package com.yuxinsheng.demotest.sync;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/17 14:43
 */
public class Test2 {
    public static void main(String[] args) {
        List<ApplyHistory> applyHistoryList = Lists.newArrayList();
        for (int i = 0; i < 20; i++) {
            ApplyHistory applyHistory = new ApplyHistory();
            applyHistory.setComment("a");
            applyHistoryList.add(applyHistory);
        }
        long currentTimeMillis = System.currentTimeMillis();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (ApplyHistory applyHistory : applyHistoryList) {
            Callable<ApplyHistory> run = new Callable<ApplyHistory>() {
                @Override
                public ApplyHistory call() throws InterruptedException {
                    String comment = "A";
                    applyHistory.setComment(comment);
                    Thread.sleep(1000);
                    System.out.println(applyHistory.getComment());
                    return applyHistory;
                }
            };
            pool.submit(run);
        }
        pool.shutdown();
        System.out.println("使用线程池一共执行：" + String.valueOf(System.currentTimeMillis() - currentTimeMillis) + "ms");
    }

    public static class ApplyHistory {

        private String comment;

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }
}
