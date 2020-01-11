package com.example.demo.thread.safe;

import java.util.Vector;

/**
 * @description: 扩展方法
 * @author: Grace.Pan
 * @create: 2020-01-10 14:37
 */
public class ExtendList<E> extends Vector<E> {
    /**
     * 脆弱，若底层改变了同步策略，用不同的锁来实现线程安全，那么子类的该方法就会破坏（非线程安全）
     * @param e
     * @return
     */
    public synchronized boolean putIfAbsent(E e){
        boolean absent = !contains(e);
        if (absent){
            add(e);
        }
        return absent;
    }
}
