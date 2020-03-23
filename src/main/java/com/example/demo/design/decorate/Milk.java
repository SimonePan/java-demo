package com.example.demo.design.decorate;

/**
 * @description: 牛奶
 * @author: Grace.Pan
 * @create: 2020-03-16 20:51
 */
public class Milk extends CondimentDecorator {
    Beverage beverage;

    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return 0.19 + beverage.cost();
    }
}
