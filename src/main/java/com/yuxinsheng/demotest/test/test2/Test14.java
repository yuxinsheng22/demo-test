package com.yuxinsheng.demotest.test.test2;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/28 13:59
 */
public class Test14 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Test14.class);

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a", "b", "c");
        LOGGER.info("所有字符串:{}", list);
        LOGGER.info("所有字符串:{}", new Gson().toJson(list));
        for (int i = 0; i < list.size(); i++) {
            LOGGER.info("第{}打印", i + 1);
        }
    }
}
