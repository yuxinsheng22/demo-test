package com.yuxinsheng.demotest.test.test4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Student student = new Student();
            student.setName("小" + i);
            student.setAge(i);
            students.add(student);
        }
        long currentTimeMillis = System.currentTimeMillis();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (Student student : students) {
            Callable<Student> run = new Callable<Student>() {
                @Override
                public Student call() throws InterruptedException {
                    String comment = "A";
                    student.setName(comment);
                    Thread.sleep(1000);
                    System.out.println(student.getName());

                    return student;
                }
            };
            pool.submit(run);
        }
        pool.shutdown();

        System.out.println("使用线程池一共执行：" + String.valueOf(System.currentTimeMillis() - currentTimeMillis) + "ms");
    }
}
