package com.yuxinsheng.demotest.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Service {
    public static void main(String[] args) {
        String data = "abc";
        System.out.println(DigestUtils.md5Hex(data));
        System.out.println(DigestUtils.md5Hex(data.getBytes()));
    }
}
