package com.example.demo.design;

/**
 * @author Grace.Pan
 * @date 2019/7/1
 */
public class SingletonDemo {

    private static volatile SingletonDemo singleton;

    private SingletonDemo() {

    }

    public static SingletonDemo getInstance() {
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    singleton = new SingletonDemo();
                }
            }
        }
        return singleton;
    }

}
