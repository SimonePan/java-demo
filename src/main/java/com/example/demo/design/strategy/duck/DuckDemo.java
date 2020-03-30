package com.example.demo.design.strategy.duck;

/**
 * @description: 鸭子测试类
 * @author: Grace.Pan
 * @create: 2020-03-30 21:16
 */
public class DuckDemo {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();
    }
}
