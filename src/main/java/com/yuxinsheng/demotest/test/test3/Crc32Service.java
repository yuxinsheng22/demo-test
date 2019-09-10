package com.yuxinsheng.demotest.test.test3;

import java.util.zip.CRC32;

public class Crc32Service {
    public static void main(String[] args) {
        String str = "https://itunes.apple.com/app-bundle/id125785401th";
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes());
        long c = crc32.getValue();
        String index = String.format("%03d", Math.floorMod(c, 100));
        System.out.println(index);
    }
}
