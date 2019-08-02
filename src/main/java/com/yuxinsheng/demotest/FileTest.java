package com.yuxinsheng.demotest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.Base64Utils;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        String path = "/yuxinsheng/test/abc.txt";
        File file = new File(path);
        String name = file.getName();
        System.out.println(name);
        String base64 = "hehe";
        System.out.println(Base64Utils.encodeToString(base64.getBytes()));
        System.out.println(DigestUtils.md5Hex(base64));
        System.out.println(DigestUtils.md5Hex(base64.getBytes()));
        System.out.println(org.springframework.util.DigestUtils.md5DigestAsHex(base64.getBytes()));

    }
}
