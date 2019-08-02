package com.yuxinsheng.demotest.test5;

public class MathService {
    public static void main(String[] args) {
        Integer a = 120;
        Integer b =60;
        Double ceil= Math.ceil(a.doubleValue()/b.doubleValue());
        System.out.println(ceil);
    }
}
