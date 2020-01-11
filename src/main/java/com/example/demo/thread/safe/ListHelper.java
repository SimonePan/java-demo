package com.example.demo.thread.safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 加锁扩展方法
 * @author: Grace.Pan
 * @create: 2020-01-10 14:41
 */
public class ListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    /**
     * 破坏封装性，相对脆弱，若底层改变同步策略，该方法则不在安全。
     *
     * @param e
     * @return
     */
    public boolean putIfAbsent(E e) {
        synchronized (list) {
            boolean absent = !list.contains(e);
            if (absent) {
                list.add(e);
            }
            return absent;
        }
    }
}
