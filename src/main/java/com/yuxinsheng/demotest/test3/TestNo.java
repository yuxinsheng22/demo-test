package com.yuxinsheng.demotest.test3;

import java.text.DecimalFormat;

/**
 * @Author: yuxinsheng
 * @Date: 2019/1/30 10:09
 */
public class TestNo {
    public static final DecimalFormat df = new DecimalFormat("#.00");
    public static void main(String[] args) {
        System.out.println(df.format(2.001));
        System.out.println(Double.valueOf(df.format(2.001)));
        System.out.println(Math.round(Double.valueOf(df.format(2.001))*100)/100.00);
        double no = 2.00;
        System.out.println(no);
    }

    public static String roundByScale(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The   scale   must   be   a   positive   integer   or   zero");
        }
        if(scale == 0){
            return new DecimalFormat("0").format(v);
        }
        String formatStr = "0.";
        for(int i=0;i<scale;i++){
            formatStr = formatStr + "0";
        }
        return new DecimalFormat(formatStr).format(v);
    }

}
