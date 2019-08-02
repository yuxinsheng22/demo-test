package com.yuxinsheng.demotest.designPattern.observer.use;

/**
 * @author yuxinsheng
 * @date 2018/11/19 10:29
 * 剁手党
 */
public class Shopaholic extends Buyer1 {

    public Shopaholic(String name, Shop1 shop1) {
        super(name, shop1);
    }

    @Override
    public void inform() {
        //我是剁手党,我看见什么买什么
        System.out.println(super.name + "购买" + shop1.getProduct());
    }
}
