package com.yuxinsheng.demotest.stringutils;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {
    public static void main(String[] args) {
        String str = "abc-123";
        String str1 = "abc";
        System.out.println(StringUtils.contains(str1,'-'));
        System.out.println(StringUtils.substring(str,0,StringUtils.indexOf(str,'-')));
    }
}
