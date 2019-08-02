package com.yuxinsheng.demotest.test2;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/3 15:55
 */
@Slf4j
public class Test11 {

    public static void main(String[] args) {
        Map<String, Object> map = getMap();
        log.info("list1{}", map.get("list1"));
        List<Student> list2 = (List<Student>) map.get("list2");
        for (Student student : list2) {
            log.info(student.toString());
        }

    }

    public static Map<String, Object> getMap() {
        List<Integer> list1 = Lists.newArrayList(1, 2, 3);
        List<Student> list2 = Lists.newArrayList(new Student(1, "小明", 18), new Student(2, "小王", 20));
        Map<String, Object> map = Maps.newHashMap();
        map.put("list1", list1);
        map.put("list2", list2);
        return map;
    }

    public static class Student {
        private int id;
        private String name;
        private int age;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
