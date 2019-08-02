package com.yuxinsheng.demotest;

import clover.com.google.gson.Gson;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class StringIndexTest {
    public static void main(String[] args) {
//        String name = "abc.png";
////        int index = name.indexOf(".");
//        int index = StringUtils.indexOf(name,".");
//        System.out.println(index);
////        String sub = name.substring(3,7);
//        String sub = StringUtils.substring(name,0,3);
//        System.out.println(sub);


        Map<String, List<String>> map = Maps.newHashMap();
        map.put("abc", Lists.newArrayList("哈哈哈", "呵呵呵"));
        System.out.println(new Gson().toJson(map));
        System.out.println(new Gson().toJson(new Vo(map)));


    }

}
