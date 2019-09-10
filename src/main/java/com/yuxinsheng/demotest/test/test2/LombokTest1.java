package com.yuxinsheng.demotest.test.test2;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yuxinsheng
 * @date 2018/11/16 17:18
 */
@Data
@Slf4j
public class LombokTest1 {

    private Long id;

    private String name;

    private int age;

    public LombokTest1() {
    }

    public LombokTest1(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        LombokTest1 test1 = new LombokTest1(1L, "小明", 18);
    }

}
