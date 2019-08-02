package com.yuxinsheng.demotest.designPattern.observer.use;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author yuxinsheng
 * @date 2018/11/19 10:03
 */
public class Shop1 {

    private String product;

    private List<Buyer1> buyers = Lists.newArrayList();

    public Shop1() {
        this.product = "无商品";
    }

    public String getProduct() {
        return product;
    }

    //客户想让我店家通知你,那么你就要来我店里注册
    public void register(Buyer1 buyer1) {
        this.buyers.add(buyer1);
    }

    //客户不想订阅我了,就把删除了
    public void delete(Buyer1 buyer1) {
        if (buyers.contains(buyer1)) {
            this.buyers.remove(buyer1);
        }
    }

    //来货了,通知所有来我店里注册的卖家
    public void setProduct(String product) {
        this.product = product;
        this.notifyBuyers();
    }

    //通知买家
    public void notifyBuyers() {
        for (Buyer1 buyer : buyers) {
            buyer.inform();
        }
    }
}
