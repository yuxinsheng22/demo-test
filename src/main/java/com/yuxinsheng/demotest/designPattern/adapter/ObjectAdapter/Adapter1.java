package com.yuxinsheng.demotest.designPattern.adapter.ObjectAdapter;

/**
 * @Author: yuxinsheng
 * @Date: 2018/11/25 23:13
 */
public class Adapter1 implements Target1 {

    @Override
    public void request() {
        Adaptee1 adaptee1 = new Adaptee1();
        adaptee1.specialRequest();
    }
}
