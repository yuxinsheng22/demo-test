package com.yuxinsheng.demotest.guancazhemoshi.chuantong;

/**
 * @author yuxinsheng
 * @date 2018/11/19 9:34
 */
public class Buyer {

    private String name;

    private Shop shop;

    public Buyer(String name, Shop shop) {
        this.name = name;
        this.shop = shop;
    }

    public void buy() {
        System.out.println(this.name + "购买");
        System.out.println(shop.getProduct());
    }
}
