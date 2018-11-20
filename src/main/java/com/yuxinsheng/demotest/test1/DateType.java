package com.yuxinsheng.demotest.test1;

/**
 * @author yuxinsheng
 * @date 2018/10/29 10:22
 */
public enum DateType {

    DAY(1), WEEK(2), MONTH(3);

    private int index;

    DateType(int index) {
        this.index = index;
    }

    public static String getName(int index) {
        for (DateType type : DateType.values()) {
            if (type.index == index) {
                return type.name();
            }
        }
        return null;
    }


}
