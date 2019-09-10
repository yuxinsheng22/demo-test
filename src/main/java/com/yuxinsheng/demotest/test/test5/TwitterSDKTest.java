package com.yuxinsheng.demotest.test.test5;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;

public class TwitterSDKTest {
    public static void main(String[] args) {
        String mediaUrl = "http://172.16.25.191:8888/group1/M00/00/0D/rBAZv11VmeuALH9kAEtcrOyvBhM375.mp4";
        try {
            byte[] data = IOUtils.toByteArray(new URL(mediaUrl));
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
