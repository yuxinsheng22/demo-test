package com.yuxinsheng.demotest.guancazhemoshi.chuantong;

/**
 * @author yuxinsheng
 * @date 2018/11/19 9:33
 */
public class Shop {

    private String product;

    public Shop() {
        this.product = "无商品";
    }

    //出货
    public String getProduct() {
        return product;
    }

    //进货
    public void setProduct(String product) {
        this.product = product;
    }
}
