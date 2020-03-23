package com.example.demo.medium;

/**
 * 函数式接口，只有一个 abstract 方法，可以包含多个默认方法、静态方法。
 * 函数式接口可以包含Object里public的方法，这些方法不会计入 abstract 方法中，虽然它们是 abstract 方法。
 * 因为任何一个函数式接口的实现，默认都继承了Object类，包含了来自Object里对这些 abstract 方法的实现。
 *
 * @author Grace.Pan
 * @date 2019/6/18
 */
@FunctionalInterface
interface FunctionalInterfaceDemo {
    void greeting(String message);

    static void printMsg(String message) {
        System.out.println("----" + message);
    }

    //默认方法，可有多个
    default void do1() {
        System.out.println("---do 1----");
    }

    default void do2() {
        System.out.println("---do 2----");
    }

    @Override
    boolean equals(Object object);

    static void main(String[] args) {
        FunctionalInterfaceDemo sss = message -> System.out.println(message);
        sss.do1();
        sss.greeting("greeting");
        sss.do2();
    }

}
