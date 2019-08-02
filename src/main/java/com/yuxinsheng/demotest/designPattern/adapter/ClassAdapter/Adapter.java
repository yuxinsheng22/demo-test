package com.yuxinsheng.demotest.designPattern.adapter.ClassAdapter;

/**
 * @Author: yuxinsheng
 * @Date: 2018/11/25 22:58
 * 适配器角色
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        super.specialRequest();
    }
}
