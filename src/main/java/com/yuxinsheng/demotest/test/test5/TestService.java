package com.yuxinsheng.demotest.test.test5;

import org.apache.commons.lang3.StringUtils;

public class TestService {
    public static void main(String[] args) {
        String url = "abc/dfa/sla/MKD";
        String s= StringUtils.substringAfterLast(url,"/");
        System.out.println(s);

    }
}
