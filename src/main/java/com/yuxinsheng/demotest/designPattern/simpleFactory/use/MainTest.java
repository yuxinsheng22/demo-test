package com.yuxinsheng.demotest.designPattern.simpleFactory.use;

/**
 * @Author: yuxinsheng
 * @Date: 2018/11/25 21:20
 */
public class MainTest {
    public static void main(String[] args) {
        //利用工厂生产一个产品
        Product product = Factory.getProduct("banana");
        //调用产品通用的方法描述
        product.desc();
    }
}
