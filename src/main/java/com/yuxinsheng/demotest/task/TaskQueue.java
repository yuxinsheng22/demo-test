package com.yuxinsheng.demotest.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.concurrent.*;

public class TaskQueue {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1000);

    /**
     * 加入队列
     *
     * @param num
     */
    public static void addQueue(Integer num) {
        queue.offer(num);
    }

    /**
     * 执行队列数据
     */
    @PostConstruct
    public void execute() {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(5);
        //十秒执行一次
        es.scheduleWithFixedDelay(() -> {
            try {
                logger.info("queue size:{}", queue.size());
                Integer num = queue.poll();
                if (Objects.nonNull(num)) {
                    System.out.println("num==" + num);
                }
            } catch (Exception e) {
                logger.info("queue error:{}", e.toString());
            }
        }, 0, 5, TimeUnit.SECONDS);
    }


}
