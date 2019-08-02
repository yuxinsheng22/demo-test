package com.yuxinsheng.demotest.file;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/20 09:50
 */
public class ImageTest {

    public static void main(String[] args) {
        String url = "https://pbs.twimg.com/ad_img/1062907942255583233/8udb0DcU?format=jpg&name=orig";
        downloadPicture(url);
    }

    //链接url下载图片
    private static void downloadPicture(String urlList) {
        try {
            URL url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            String imageName =  "/yuxinsheng/test/test1.jpg";
            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
