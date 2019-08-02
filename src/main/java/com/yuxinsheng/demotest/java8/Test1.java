package com.yuxinsheng.demotest.java8;

import java.util.function.Function;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(compute(5));

    }

    public static int compute(Integer n){
        Function<Integer,Integer> function = a -> a*a;
        return function.apply(n);
    }
}
