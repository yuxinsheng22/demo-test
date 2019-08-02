package com.yuxinsheng.demotest.test4;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class StringTestServcie {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = "adaccounts{id,name,account_id,account_status}";
        String b = URLEncoder.encode(a, "utf-8");
        System.out.println(b);
        System.out.println(URLDecoder.decode(b, "utf-8"));
    }
}
