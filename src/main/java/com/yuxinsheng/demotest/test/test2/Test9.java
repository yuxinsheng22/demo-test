package com.yuxinsheng.demotest.test.test2;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/2 10:16
 */
@Slf4j
public class Test9 {
    public static void main(String[] args) {
        Map<String, Object> map = getList();
        List<Integer> list1 = (List<Integer>) map.get("list1");
        List<Integer> list2 = (List<Integer>) map.get("list2");
        log.info("list1:{}", list1);
        log.info("list2{}", list2);
    }

    public static Map<String, Object> getList() {
        Map<String, Object> map = Maps.newHashMap();
        ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("cache-init-%d").build();
        ExecutorService threadPool = new ThreadPoolExecutor(11, 11, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), factory, new ThreadPoolExecutor.AbortPolicy());
        List<Integer> list1 = Lists.newArrayList();
        List<Integer> list2 = Lists.newArrayList();
        threadPool.execute(() -> {
            list1.add(1);
            list1.add(2);
            list1.add(3);
            log.info("新启线程[1]执行完毕");
        });
        threadPool.execute(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(10);
            list2.add(11);
            list2.add(12);
            log.info("新启线程[2]执行完毕");
        });
        map.put("list1", list1);
        map.put("list2", list2);
        return map;
    }
}
