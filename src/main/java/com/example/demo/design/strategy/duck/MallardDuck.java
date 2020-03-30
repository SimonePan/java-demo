package com.example.demo.design.strategy.duck;

/**
 * @description: 绿头鸭
 * @author: Grace.Pan
 * @create: 2020-03-30 21:11
 */
public class MallardDuck extends Duck {

    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display(){
        System.out.println("I'm a real Mallard Duck.");
    }
}
