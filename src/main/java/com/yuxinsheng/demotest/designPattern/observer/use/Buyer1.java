package com.yuxinsheng.demotest.designPattern.observer.use;

/**
 * @author yuxinsheng
 * @date 2018/11/19 10:06
 */
public abstract class Buyer1 {
    protected String name;
    protected Shop1 shop1;

    public Buyer1(String name, Shop1 shop1) {
        this.name = name;
        this.shop1 = shop1;
    }

    public abstract void inform();
}
