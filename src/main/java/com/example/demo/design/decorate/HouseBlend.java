package com.example.demo.design.decorate;

/**
 * @description: 蒸馏咖啡
 * @author: Grace.Pan
 * @create: 2020-03-16 20:48
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
