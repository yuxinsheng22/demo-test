package com.yuxinsheng.demotest.guancazhemoshi.chuantong;

/**
 * @author yuxinsheng
 * @date 2018/11/19 9:37
 */
public class Client {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Buyer wukong = new Buyer("悟空", shop);
        Buyer bajie = new Buyer("八戒", shop);

        wukong.buy();
        bajie.buy();
        wukong.buy();
        bajie.buy();
        bajie.buy();
        //.....

        //师傅唐僧加入购买队列
        Buyer sanzang = new Buyer("唐僧", shop);
        sanzang.buy();
        sanzang.buy();
        //依然没货,,买不到

        bajie.buy();
        bajie.buy();

        //终于商店进货了
        shop.setProduct("唐僧肉");
        bajie.buy();//如愿以偿的吃到了唐僧肉


    }
}
