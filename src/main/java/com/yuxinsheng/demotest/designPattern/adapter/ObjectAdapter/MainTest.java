package com.yuxinsheng.demotest.designPattern.adapter.ObjectAdapter;

/**
 * @Author: yuxinsheng
 * @Date: 2018/11/25 23:14
 */
public class MainTest {
    public static void main(String[] args) {
        Target1 target1 = new Adapter1();
        target1.request();
    }

    /**
     * 适配器模式不适合在详细设计阶段使用它，它是一种补偿模式，
     * 专用来在系统后期扩展、修改时所用，适配器模式更像是一种补救措施。
     */
}
