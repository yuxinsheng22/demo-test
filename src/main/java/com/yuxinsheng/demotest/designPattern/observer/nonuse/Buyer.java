package com.yuxinsheng.demotest.designPattern.observer.nonuse;

/**
 * @Author: yuxinsheng
 * @Date: 2018/11/25 20:54
 */
public class Buyer {

    private String name;// 买家姓名
    private Shop shop;// 商店引用

    public Buyer(String name, Shop shop) {
        this.name = name;
        this.shop = shop;
    }

    public void buy() {// 买家购买商品
        System.out.print(name + "购买：");
        System.out.println(shop.getProduct());
    }
}
