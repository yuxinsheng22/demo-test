package com.yuxinsheng.demotest.test.test3;

import com.google.common.collect.Lists;

import java.util.List;

public class PageService {

    public static <T> List<T> page(List<T> list, Integer currentPage, Integer pageSize) {
        List<T> response = Lists.newArrayList();
        if (list != null) {
            int total = list.size();
            if (currentPage * pageSize > total) {
                response = list.subList((currentPage - 1) * pageSize, total);
            } else {
                response = list.subList((currentPage - 1) * pageSize, currentPage * pageSize);
            }
        }
        return response;
    }

    public static void main(String[] args) {
//        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
//        List<Integer> list1 = PageService.page(list, 2, 3);
//        System.out.println(list1);

        List<String> list = Lists.newArrayList("1", "2", "3", "4", "5", "6");
        System.out.println(PageService.page(list, 1, 2));
    }
}
