package com.example.demo.design.strategy.duck;

/**
 * @description: 飞行
 * @author: Grace.Pan
 * @create: 2020-03-30 21:10
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}
