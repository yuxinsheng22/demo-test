package com.yuxinsheng.demotest.test.test3;

import java.math.BigDecimal;

/**
 * @Author: yuxinsheng
 * @Date: 2019/1/30 10:27
 */
public class TestNo2 {
    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal(2.191);
        double d1 = bd.setScale(2, BigDecimal.ROUND_CEILING).doubleValue();
        System.out.println(d1);
    }
}
