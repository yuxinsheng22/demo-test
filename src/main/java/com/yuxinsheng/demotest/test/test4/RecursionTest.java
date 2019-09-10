package com.yuxinsheng.demotest.test.test4;

public class RecursionTest {

    public static void main(String[] args) {
        System.out.println(recursion(10));

    }

    public static int recursion(int n) {
        if (n <= 5) {
            return 1;
        } else {
            return recursion(n - 1);
        }
    }
}
