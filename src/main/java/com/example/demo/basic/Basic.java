package com.example.demo.basic;

/**
 * @author Grace.Pan
 * @date 2019/6/17
 */
public class Basic extends BasicBase {

    static int i = 9;
    String nick;

    //{ } 构造块，只要对象创建就会执行一次。一个类允许有多个构造块。
    {
        System.out.println("本类 构造块1-----");
    }

    static {
        System.out.println("本类 静态成员变量-----" + i);
        System.out.println("本类 静态代码块-----");
    }

    public Basic() {
        System.out.println("本类 默认构造方法-----");
    }

    static void methodA() {
        System.out.println("本类 静态方法-----");
    }

    public Basic(String nick) {
        this.nick = nick;
        System.out.println("本类 有参构造方法-----");
    }

    {
        System.out.println("本类 构造块2-----");
    }

    public void print() {
        System.out.println("本类 print 方法-----" + nick + "---" + i);
    }

    @Override
    public void overrideMethod() {
        System.out.println("本类 overrideMethodm 方法-----" + nick + "---" + i);
    }
}
