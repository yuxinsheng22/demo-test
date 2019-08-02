package com.yuxinsheng.demotest.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest1 {
    public static void main(String[] args) throws IOException {
        System.out.println(read());
    }

    private static String read() throws IOException {
        File file = new File("/yuxinsheng/test/abc.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String s;
        StringBuilder sb = new StringBuilder();

        while ((s = in.readLine()) != null) {
            sb.append(s);
        }
        in.close();
        return sb.toString();
    }

}
