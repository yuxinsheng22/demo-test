package com.yuxinsheng.demotest.file;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/18 15:33
 */
public class FileTest1 {

    /**
     * @param fileType：图片类型（jpg/png/gif/bmp）
     * @param bytes：文件流
     * @方法说明 将图片存到指定路径，并返回该完整路径
     */
    public static String getFileImages(String fileType, byte[] bytes) {
        //系统临时目录
        String tempPath = "/yuxinsheng";
        String fileName = createImageName() + "." + fileType;
        String filePath = tempPath + "/" + fileName;
        try {
            if (bytes != null) {
                //生成文件
                File file = new File(filePath);
                FileUtils.writeByteArrayToFile(file, bytes);
                FileInputStream inputStream = new FileInputStream(file);
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, len);
                }
                inputStream.close();
                outStream.flush();
                outStream.close();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return filePath;
    }

    /**
     * @方法说明 生成文件名称
     * @createDate 2016-5-15
     */
    public static String createImageName() {
        //根据时间生成文件名
        SimpleDateFormat sdf = new SimpleDateFormat("ddHHmmss");
        String fileName = sdf.format(new Date());
        //加上随机数，防止重复
        Random rand = new Random();
        fileName += String.valueOf(rand.nextInt(100));
        return fileName;
    }

    private static byte[] getBytes(String filePath){
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public static void main(String[] args) {
        System.out.println(getFileImages("png",getBytes("/yuxinsheng/resource/yxs.jpg")));
    }
}
