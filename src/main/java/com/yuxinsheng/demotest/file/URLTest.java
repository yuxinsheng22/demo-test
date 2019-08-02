package com.yuxinsheng.demotest.file;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/20 15:37
 */
public class URLTest {
    public static void main(String[] args) throws IOException {
        System.out.println(get());

    }

    public static String get() throws IOException {
        String url = "/yuxinsheng/test/test1.jpg";
        URLConnection urlConnection = new URL(url).openConnection();
        System.out.println(urlConnection.getContentLength());
        System.out.println(urlConnection.getHeaderField("Content-Length"));
        return urlConnection.getHeaderField("Content-Length");
    }
}
