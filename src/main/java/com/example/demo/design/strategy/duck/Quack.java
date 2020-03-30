package com.example.demo.design.strategy.duck;

/**
 * @description: 呱呱叫
 * @author: Grace.Pan
 * @create: 2020-03-30 21:10
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}
