package com.yuxinsheng.demotest.test.test5;

import com.google.common.collect.Lists;
import com.google.gson.Gson;

import java.util.List;

public class JsonTest {
    public static void main(String[] args) {
        Gson gson = new Gson();
        List<Integer> list = Lists.newArrayList(1, 2);
        String json = gson.toJson(list);
        System.out.println(json);
        List list1 = gson.fromJson(json,List.class);
        System.out.println(list1);
    }
}
