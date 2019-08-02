package com.yuxinsheng.demotest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CommonsIoService {
//    public static void main(String[] args) throws FileNotFoundException {
//        String path = "/yuxinsheng/test/file.rtf";
//        String path1 = "/yuxinsheng/test/abc.txt";
//        File file = new File(path1);
//        try {
//            List<String> contents = FileUtils.readLines(file, "UTF-8");
//            contents.forEach(System.out::println);
////            FileUtils.writeStringToFile(file,"呵呵","utf-8");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }



//    public static void main(String[] args) {
//        String path = "/yuxinsheng/test/";
//        File file = new File(path + "abc.txt");
//        try {
//            byte[] data = FileUtils.readFileToByteArray(file);
//            FileUtils.writeByteArrayToFile(new File(path + "d.txt"), data);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }


    public static void main(String[] args) {
        try{
            byte[] bytes = new byte[4];
            InputStream is = IOUtils.toInputStream("hello world","UTF-8");
            IOUtils.read(is, bytes);
            System.out.println(new String(bytes));

            bytes = new byte[10];
            is = IOUtils.toInputStream("hello world","UTF-8");
            IOUtils.read(is, bytes, 2, 4);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
