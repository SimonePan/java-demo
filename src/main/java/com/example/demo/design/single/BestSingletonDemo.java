package com.example.demo.design.single;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2020-03-16 16:56
 */
public class BestSingletonDemo {
    private static BestSingletonDemo singleton = new BestSingletonDemo();

    public BestSingletonDemo getSingleton() {
        return singleton;
    }
}
