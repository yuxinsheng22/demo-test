package com.yuxinsheng.demotest.designPattern.simpleFactory.use;

/**
 * @Author: yuxinsheng
 * @Date: 2018/11/25 21:17
 */
public class ConcreteProductBanana implements Product {
    @Override
    public void desc() {
        System.out.println("我是香蕉");
    }
}
