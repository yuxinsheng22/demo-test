package com.yuxinsheng.demotest.test2;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: yuxinsheng
 * @Date: 2018/12/2 19:04
 */
public class Test10 {
    private static Queue<String> queue = new LinkedBlockingQueue();//定义一个队列来存储数据

    static class Input extends Thread {// 接收控制台输入

        public void run() {
            String name = null;
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入字符串：");

            while (true) {
                name = sc.nextLine();
                // 如果立即可行且不违反容量限制，
                // 则将指定的元素插入此双端队列表示的队列中（即此双端队列的尾部），
                // 并在成功时返回 true；如果当前没有空间可用，则返回 false
                queue.offer(name);
                if ("exit".equals(name))
                    break;
                synchronized (queue) {//notify()是Object()中定义的方法所以只能用在synchronized()方法中。
                    queue.notify();//唤醒, 在负责输出线程中的等待的 告诉队列中有元素了 它可以输出了
                }
            }
        }
    }

    static class Test14 extends Thread {
        public void run() {
            while (true) {
                if (queue.size() > 0) {
                    //System.out.println(queue.size());
                    String name = queue.poll();
                    System.out.println(name);
                } else {
                    synchronized (queue) {
                        try {
                            queue.wait();//相当于queue.wait(0),队列中没有东西则默认无限等待直到队列中有东西并且通知他
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }//如果队列中没有东西则等待
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Input().start();
        new Test14().start();
    }

}
