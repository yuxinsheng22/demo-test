package com.yuxinsheng.demotest.test.test1;

/**
 * @author yuxinsheng
 * @date 2018/10/17 11:15
 */
public enum Color1 implements Behaviour {

    RED("红色", 1), GREEN("绿色", 2), WHITE("白色", 3), YELLO("黄色", 4);

    private String name;
    private int index;

    Color1(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public void print() {
        System.out.println(this.index + this.name);
    }

    @Override
    public String getInfo() {
        return this.name;
    }

    public static void main(String[] args) {

        Color color = Color.RED;
        String name  = color.name();
        System.out.println(color.ordinal());
        System.out.println(name);


    }
}
