package com.yuxinsheng.demotest.test3;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class ListServiceTest {
    public static void main(String[] args) {
        List<User> list = Lists.newArrayList();
        list = null;
        List<String> names = list.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(names);

    }

    public class User {
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
