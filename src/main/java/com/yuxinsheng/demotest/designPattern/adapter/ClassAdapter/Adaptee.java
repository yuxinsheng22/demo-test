package com.yuxinsheng.demotest.designPattern.adapter.ClassAdapter;

/**
 * @Author: yuxinsheng
 * @Date: 2018/11/25 22:57
 * 源角色
 */
public class Adaptee {

    public void specialRequest() {
        System.out.println("我是源角色，我改不了，你要调用我，你去找适配器去吧");
    }
}
