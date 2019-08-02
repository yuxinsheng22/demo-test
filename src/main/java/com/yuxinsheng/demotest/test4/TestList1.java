package com.yuxinsheng.demotest.test4;

import com.google.common.collect.Lists;

import java.util.List;

public class TestList1 {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        for (Integer i : list) {
            List<String> strings = Lists.newArrayList("a", "b", "c");
            int temp;
            if (strings.contains("d")) {
                temp = 1;
                System.out.println("d");
            } else if (strings.contains("e")) {
                temp = 2;
                System.out.println("e                                                                                                                                                                                                                                                                                                                                                                   ");
            } else {
                temp = 3;
                System.out.println("b");
            }
            System.out.println("temp=" + temp);
        }
    }





}
