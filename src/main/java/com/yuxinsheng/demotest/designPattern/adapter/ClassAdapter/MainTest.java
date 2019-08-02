package com.yuxinsheng.demotest.designPattern.adapter.ClassAdapter;

/**
 * @Author: yuxinsheng
 * @Date: 2018/11/25 22:58
 */
public class MainTest {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
