package com.yuxinsheng.demotest.test.test3;

import com.google.common.collect.Lists;

import java.util.List;

public class ListService {
    public static void main(String[] args) {
//        List<Integer>  list = Lists.newArrayList(1,2,1,3);
//        Set<Integer> set = Sets.newHashSet(list);
//        System.out.println(set);
        List<Integer> list1 = Lists.newArrayList(1,2,3);
        List<Integer> list2 = Lists.newArrayList(4,5,6);
        list2.addAll(list1);
        System.out.println(list2);
     }
}
