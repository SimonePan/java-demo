package com.example.demo.design.single;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2020-03-17 16:30
 */
public enum EnumSingleton {
    INSTANCE;

    public void fun1() {
        System.out.println("fun1");
    }

    public static void main(String[] args) {
        EnumSingleton.INSTANCE.fun1();
    }
}
