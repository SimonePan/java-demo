package com.example.demo.design.decorate;

/**
 * @description: 摩卡☕️
 * @author: Grace.Pan
 * @create: 2020-03-16 20:51
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return 0.29 + beverage.cost();
    }
}
