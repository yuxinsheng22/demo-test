package com.yuxinsheng.demotest.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamTest1 {
    public static void main(String[] args) {
        read();
    }

    private static String read() {
        StringBuilder sb = new StringBuilder();
        File file = new File("/yuxinsheng/test/abc.txt");
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, len));
            }
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
