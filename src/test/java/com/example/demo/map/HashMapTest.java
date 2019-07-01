package com.example.demo.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Grace.Pan
 * @date 2019/6/26
 */
@Slf4j
public class HashMapTest {

    @Test
    public void testHashMap(){
        HashMap<String, String> map = new HashMap<>();
        // 数组+链表实现。
        // 数组的元素：Node<K,V>[] table;每个Node都是链表的头节点。
        // size 实际存储的键值对个数。
        // DEFAULT_INITIAL_CAPACITY=16，MAXIMUM_CAPACITY=2^30 指的是数组长度。
        // threshold：数组长度大于该值就需扩容。threshold = capacity * loadFactor。
        // loadFactor：默认0.75。
        // modCount：修改次数，包括扩容操作。
    }

    @Test
    public void testInt(){
        int n = 16;
        System.out.println(n >>> 2);
        int sc = n - (n >>> 2);
        System.out.println(sc);
    }

}
