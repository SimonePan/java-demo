package com.example.demo.thread.unsafe;

import java.util.Vector;

/**
 * @description: 同步容器
 * @author: Grace.Pan
 * @create: 2020-01-11 10:08
 */
public class SynchronizedContainer<E> {

    public void foreach(Vector<E> vector) {
        for (int i = 0; i < vector.size(); i++) {
            // 可能抛出ArrayIndexOutOfBoundsException
            doSomething(vector.get(i));
        }
        // 可能抛出ConcurrentModificationException
        vector.forEach(this::doSomething);
    }

    private void doSomething(E e) {

    }

}
