package com.yuxinsheng.demotest.test.test3;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class StringService {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a", "b", "");
        List<String> filtered = list.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);
    }
}
