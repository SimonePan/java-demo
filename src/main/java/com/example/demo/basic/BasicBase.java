package com.example.demo.basic;

/**
 * @author Grace.Pan
 * @date 2019/6/17
 */
public class BasicBase<T> {

    static int j = 10;
    String name;
    T t;

    //{ } 构造块，只要对象创建就会执行一次。
    {
        System.out.println("父类 构造块1-----");
    }

    static {
        System.out.println("父类 静态代码块-----");
        System.out.println("父类 静态成员变量-----" + j);
    }

    public BasicBase() {
        System.out.println("父类 默认构造方法-----");
    }

    static void methodA() {
        System.out.println("父类 静态方法-----");
    }


    public BasicBase(String name) {
        this.name = name;
        System.out.println("父类 有参构造方法-----");
    }

    {
        System.out.println("父类 构造块2-----");
    }

    private void print() {
        System.out.println("父类 print方法-----" + name + "---" + j);
    }

    public void overrideMethod() {
        System.out.println("本类 overrideMethodm 方法-----" + name + "---" + j);
    }

}
