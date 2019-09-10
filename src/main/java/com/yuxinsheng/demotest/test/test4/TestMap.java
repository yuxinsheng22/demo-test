package com.yuxinsheng.demotest.test.test4;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestMap {
    public static void main(String[] args) {

        Student student1 = new Student("小明", 10);
        Student student2 = new Student("小李", 10);
        Student student3 = new Student("小王", 11);
        Student student4 = new Student("小张", 11);
        List<Student> list = Lists.newArrayList(student1, student2, student3, student4);
        Map<Integer, List<String>> map = Maps.newHashMap();
        Set<Integer> ageSet = Sets.newHashSet();
        for (Student student : list) {
            if (!ageSet.contains(student.getAge())) {
                ageSet.add(student.getAge());
                map.put(student.getAge(), Lists.newArrayList(student.getName()));
            } else {
                map.get(student.getAge()).add(student.getName());
            }
        }
        System.out.println(new Gson().toJson(map));
    }

}
