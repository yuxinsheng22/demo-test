package com.yuxinsheng.demotest.test5;

import clover.org.apache.commons.codec.digest.DigestUtils;

public class Md5Service {

    public static void main(String[] args) {
        String a = "fadsfaf";
        String code = DigestUtils.md5Hex(a.getBytes());
        System.out.println(code.length());
    }
}
