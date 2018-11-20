package com.yuxinsheng.demotest.test1;

/**
 * @author yuxinsheng
 * @date 2018/10/17 11:15
 */
public enum Color {

    RED("红色", 1), GREEN("绿色", 2), WHITE("白色", 3), YELLO("黄色", 4);

    private String name;
    private int index;

    Color(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (Color c : Color.values()) {
            if (c.index == index) {
                return c.name;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("颜色是:" + Color.getName(1));
    }
}
