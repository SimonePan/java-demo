package com.example.demo.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;

/**
 * @author Grace.Pan
 * @date 2019/6/23
 */
public class ListTest {

    @Test
    public void testSort() {
        List<String> strings = Arrays.asList(" as  ", " asdf  ", " asd  ");
        strings.sort((x, y) -> x.length() - y.length());
        strings.forEach(System.out::println);

        strings.replaceAll(String::trim);
        strings.forEach(System.out::println);
    }

    /**
     * Arrays.asList(T... a); 返回的是List.class中一个静态内部类，该类未实现List接口。
     */
    @Test
    public void testArraysAsList() {
        String[] strs = {" as  ", " asdf  ", " asd  "};
        List<String> list = Arrays.asList(strs);
        strs[0] = "changed";
        Assert.assertEquals(strs[0], list.get(0));

        doThrow(new UnsupportedOperationException()).when(list.add(anyString()));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testArraysAsList_whenOperator() throws UnsupportedOperationException {
        String[] strs = {" as  ", " asdf  ", " asd  "};
        List<String> list = Arrays.asList(strs);
        list.add(anyString());
    }

    /**
     * .subList()返回的是ArrayList的内部类SubList。SubList是ArrayList的一个视图，
     */
    @Test
    public void testArraysSubList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        List<String> strings = arrayList.subList(0, 2);
        strings.remove("b");
        // 操作SubList，实际也操作了ArrayList。因为SubList和ArrayList指向同一个数组。
        Assert.assertEquals(arrayList.get(1), "c");
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testArraysSubList_whenOperatorOld() throws ConcurrentModificationException {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        List<String> strings = arrayList.subList(0, 2);
        strings.forEach(System.out::println);
        //操作原来的ArrayList后，操作SubList会抛异常。
        arrayList.remove("a");
        strings.forEach(System.out::println);
    }

    @Test
    public void testListToArray() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        //toArray()只能返回Object[]类，使用时强转可能出现ClassCastException
        Object[] objects = arrayList.toArray();
        //推荐使用toArray(T[] a),且数组长度=0。
        String[] strings = arrayList.toArray(new String[0]);
        //arrayList.add("d");
        System.out.println(arrayList.size());
        LinkedList<Object> objects1 = new LinkedList<>();
        objects1.toArray();
    }

    @Test
    public void testUpdate() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        //toArray()只能返回Object[]类，使用时强转可能出现ClassCastException
        Object[] objects = arrayList.toArray();
        //推荐使用toArray(T[] a),且数组长度=0。
        String[] strings = arrayList.toArray(new String[0]);
        //arrayList.add("d");
        System.out.println(arrayList.size());
        LinkedList<Object> objects1 = new LinkedList<>();
        objects1.toArray();
    }

}
