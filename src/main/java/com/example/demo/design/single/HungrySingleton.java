package com.example.demo.design.single;

/**
 * @description: 饿汉式
 * @author: Grace.Pan
 * @create: 2020-03-17 16:34
 */
public class HungrySingleton {
    /**
     * 由于类装载的过程是由类加载器（ClassLoader）来执行的，这个过程也是由JVM来保证同步的，
     */
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
    }

    private static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
