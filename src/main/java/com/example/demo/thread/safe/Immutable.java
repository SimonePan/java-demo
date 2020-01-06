package com.example.demo.thread.safe;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 不可变对象
 * @author: Grace.Pan
 * @create: 2020-01-06 20:28
 */
public class Immutable {

    private final Set<Integer> set = new HashSet<>();

    public Immutable() {
        set.add(1);
        set.add(2);
        set.add(3);
    }

    public boolean isExist(Integer integer) {
        return set.contains(integer);
    }
}
