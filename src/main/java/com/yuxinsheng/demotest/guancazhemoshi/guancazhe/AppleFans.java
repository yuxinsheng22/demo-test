package com.yuxinsheng.demotest.guancazhemoshi.guancazhe;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yuxinsheng
 * @date 2018/11/19 10:12
 * 果粉
 */
public class AppleFans extends Buyer1 {

    public AppleFans(String name, Shop1 shop1) {
        super(name, shop1);
    }

    @Override
    public void inform() {
        String product = shop1.getProduct();
        //我是果粉,我就要买苹果x
        if (StringUtils.equals(product, "苹果X")) {
            System.out.println(super.name + "购买" + product);
        }
    }
}
