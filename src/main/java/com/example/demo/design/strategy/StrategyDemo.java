package com.example.demo.design.strategy;

/**
 * @description: demo
 * @author: Grace.Pan
 * @create: 2020-03-12 13:53
 */
public class StrategyDemo {
    public static void main(String[] args) {
        Koi koi = new Koi();
        koi.swim();
        koi.bless();
        FlyingFish flyingFish = new FlyingFish();
        flyingFish.swim();
        flyingFish.fly();
    }
}
