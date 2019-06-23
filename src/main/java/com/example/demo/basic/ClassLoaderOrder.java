package com.example.demo.basic;

/**
 * @author Grace.Pan
 * @date 2019/6/17
 */
public class ClassLoaderOrder {

    public static void main(String[] args) {
        Basic basic = new Basic();
        boolean b = basic instanceof Basic;
        boolean b2 = basic instanceof BasicBase;
        System.out.println(b);
        System.out.println(b2);
    }

    private void prim() {
        BasicBase c = new Basic();
        c.overrideMethod();
    }

    private void order() {
        System.out.println("-----------****子类加载顺序*****-------------------");
        Basic basic = new Basic();
        basic.overrideMethod();

        System.out.println("-----------*****父类加载顺序****-------------------");
        BasicBase basicBase = new BasicBase();
        basicBase.overrideMethod();

        System.out.println("-----------****子类有参构造*****-------------------");
        Basic basic1 = new Basic("10");

        System.out.println("-----------****父类有参构造*****-------------------");
        BasicBase basicBase1 = new BasicBase("10");

        System.out.println("-----------****子类构造块*****-------------------");
        Basic basic2 = new Basic();
        System.out.println("-----------****父类构造块*****-------------------");
        BasicBase basicBase2 = new BasicBase();

        System.out.println("-----------****静态方法*****-------------------");
        Basic.methodA();
        BasicBase.methodA();
    }
}
