package com.example.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: -verbose:gc -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemory
 * @author: Grace.Pan
 * @create: 2020-10-28 17:04
 */
public class HeapOOM {

    static class ObjectOOM{
    }

    public static void main(String[] args) {
        List<ObjectOOM> list = new ArrayList<>();
        while (true){
            list.add(new ObjectOOM());
        }
    }
}
