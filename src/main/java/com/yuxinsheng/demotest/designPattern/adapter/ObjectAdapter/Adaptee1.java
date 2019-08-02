package com.yuxinsheng.demotest.designPattern.adapter.ObjectAdapter;

/**
 * @Author: yuxinsheng
 * @Date: 2018/11/25 23:12
 */
public class Adaptee1 {

    public void specialRequest() {
        System.out.println("我是源角色，我改不了，你要调用我，你去找适配器去吧");
    }
}
