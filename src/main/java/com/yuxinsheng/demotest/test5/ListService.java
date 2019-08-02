package com.yuxinsheng.demotest.test5;

import com.google.common.collect.Lists;
import com.google.gson.Gson;

import java.util.List;

public class ListService {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a","b");
        System.out.println(new Gson().toJson(list));
    }
}
