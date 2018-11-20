package com.yuxinsheng.demotest.guancazhemoshi.guancazhe;

/**
 * @author yuxinsheng
 * @date 2018/11/19 10:33
 */
public class Client1 {
    public static void main(String[] args) {
        Shop1 shop = new Shop1();
        AppleFans tangzhagnlao = new AppleFans("果粉唐长老", shop);
        Shopaholic bajie = new Shopaholic("剁手党八戒", shop);
        shop.register(tangzhagnlao);
        shop.register(bajie);
        shop.delete(bajie);
        shop.setProduct("苹果X");
        shop.setProduct("大盘鸡");
    }
}
