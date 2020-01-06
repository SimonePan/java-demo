package com.example.demo.thread.safe;

import com.example.demo.thread.common.Publish;

/**
 * @description: 单例
 * @author: Grace.Pan
 * @create: 2020-01-06 20:37
 */
public class SinleInstance {
    /**
     * 静态的初始化器由JVM在类的初始化阶段执行。
     * 由于JVM内部存在同步机制，因此通过该方式初始化的对象可以被安全的发布。
     */
    public static Publish publish = new Publish();
}
