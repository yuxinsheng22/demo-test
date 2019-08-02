package com.yuxinsheng.demotest.test2;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/2 09:59
 */
@Slf4j
public class Test8 {

    public static void main(String[] args) {
        log.info("主线程开始运行了。。。");
        System.out.println("先输出,hello world");
        List<Integer> list = Lists.newArrayList();
        Thread t = new Thread(() -> {
            list.add(1);
            list.add(2);
            list.add(3);

        });
        t.start();
        if (CollectionUtils.isNotEmpty(list)) {
            System.out.println(list);
        }
    }


}
