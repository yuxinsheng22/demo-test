package com.yuxinsheng.demotest.test.test3;

import com.google.common.collect.Lists;

import java.util.List;

public class MyComparator {


//    @Override
//    public int compare(AppDetail o1, AppDetail o2) {
//        // 获取比较的字符串
//        String compareValue1 = o1.getVersion();
//        String compareValue2 = o2.getVersion();
//        String[] valueSplit1 = compareValue1.split("[.]");
//        String[] valueSplit2 = compareValue2.split("[.]");
//        int minLength = valueSplit1.length;
//        if (minLength > valueSplit2.length) {
//            minLength = valueSplit2.length;
//        }
//        for (int i = 0; i < minLength; i++) {
//            int value1 = Integer.parseInt(valueSplit1[i]);
//            int value2 = Integer.parseInt(valueSplit2[i]);
//            if (value1 > value2) {
//                return 1;
//            } else if (value1 < value2) {
//                return -1;
//            }
//        }
//        return valueSplit1.length - valueSplit2.length;
//    }

    public static void main(String[] args) {

        AppDetail app1 = new AppDetail("1", "2.1.0");
        AppDetail app2 = new AppDetail("2", "1.0.0.1.1");
        AppDetail app3 = new AppDetail("3", "1.0.2");
        AppDetail app4 = new AppDetail("4", "0.1.1");
        AppDetail app5 = new AppDetail("5", "0.0.2");
        AppDetail app6 = new AppDetail("6", "1.2.0");
        AppDetail app7 = new AppDetail("7", "1.1.1.2.0.2");
        AppDetail app8 = new AppDetail("8", "2.2.2.2.2.1");
        AppDetail app9 = new AppDetail("9", "1.2");
        AppDetail app10 = new AppDetail("10", "2.1.2");

        List<AppDetail> list = Lists.newArrayList(app1, app2, app3, app4, app5, app6, app7, app8, app9, app10);
//        MyComparator myComparator = new MyComparator();
//        Arrays.sort(list.toArray(new AppDetail[0]), myComparator);


        list.sort((o1, o2) -> {
            String compareValue1 = o1.getVersion();
            String compareValue2 = o2.getVersion();
            String[] valueSplit1 = compareValue1.split("[.]");
            String[] valueSplit2 = compareValue2.split("[.]");
            int minLength = valueSplit1.length;
            if (minLength > valueSplit2.length) {
                minLength = valueSplit2.length;
            }
            for (int i = 0; i < minLength; i++) {
                int value1 = Integer.parseInt(valueSplit1[i]);
                int value2 = Integer.parseInt(valueSplit2[i]);
                if (value1 > value2) {
                    return -1;
                } else if (value1 < value2) {
                    return 1;
                }
            }
            return valueSplit1.length - valueSplit2.length;
        });
        List<String> versions = Lists.newArrayList();
        for (AppDetail app : list) {
            versions.add(app.getVersion());
        }
        System.out.println(versions);

    }
}
