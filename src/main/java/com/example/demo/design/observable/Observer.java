package com.example.demo.design.observable;

/**
 * @description: 观察者
 * @author: Grace.Pan
 * @create: 2020-03-16 14:12
 */
public interface Observer {
    void update(Subject subject, Object args);
}
