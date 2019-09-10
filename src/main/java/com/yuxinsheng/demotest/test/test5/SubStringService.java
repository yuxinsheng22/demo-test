package com.yuxinsheng.demotest.test.test5;

import org.apache.commons.lang3.StringUtils;

public class SubStringService {
    public static void main(String[] args) {
//        String str = "abc.dh";
//        int index = StringUtils.indexOf(str,'.');
//        System.out.println(index);
//        String sub = StringUtils.substring(str,index,4);
//        System.out.println(sub);

        String storeUrl = "https://play.google.com/store/apps/details?id=com.abc&hl=ja";
        storeUrl = StringUtils.substring(storeUrl,0,StringUtils.indexOf(storeUrl,'&'));
        System.out.println(storeUrl);
        System.out.println(storeUrl.contains("play.google.com"));
    }
}
