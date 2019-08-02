package com.yuxinsheng.demotest.test2;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yuxinsheng
 * @Date: 2019/1/3 11:55
 */
public class Test17 {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8);
        System.out.println(page(list,1,10));

    }

    public static List<Integer> page(List<Integer> list, Integer currentPage, Integer pageSize) {
        List<Integer> ret = new ArrayList();
        if (list != null) {
            int total = list.size();
            if (currentPage * pageSize > total) {
                ret = list.subList((currentPage - 1) * pageSize, total);
            } else {
                ret = list.subList((currentPage - 1) * pageSize, currentPage * pageSize);
            }
        }
        return ret;
    }
}
