package com.yuxinsheng.demotest.test.test3;

import com.google.common.collect.Lists;

import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        List<Integer> list1 = Lists.newArrayList(1, 2, 3);
        for (Integer i : list1) {
            if (list.contains(i)) {
                System.out.println("list包含" + i);
            } else {
                System.out.println("list不包含" + i);
            }
        }
    }
}
