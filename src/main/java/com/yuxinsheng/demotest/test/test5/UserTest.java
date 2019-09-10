package com.yuxinsheng.demotest.test.test5;

import clover.com.google.gson.Gson;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserTest {
    public static void main(String[] args) {
        List<User> users = Lists.newArrayList(new User(1L, "小明", 60D), new User(2L, "小王", 70D), new User(3L, "小张", 60D));
        Map<String, User> map1 = users.stream().collect(Collectors.toMap(User::getName, Function.identity()));
        Map<Double,List<User>> map2 = users.stream().collect(Collectors.groupingBy(User::getScore));
        System.out.println(new Gson().toJson(map1));
        System.out.println(new Gson().toJson(map2));
    }
}
