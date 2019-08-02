package com.yuxinsheng.demotest.designPattern.observer.nonuse;

/**
 * @Author: yuxinsheng
 * @Date: 2018/11/25 20:54
 */
public class Shop {

    private String product;//商品
    //初始商店无货
    public Shop() {
        this.product = "无商品";
    }
    //商店出货
    public String getProduct() {
        return product;
    }
    //商店进货
    public void setProduct(String product) {
        this.product = product;
    }
}
