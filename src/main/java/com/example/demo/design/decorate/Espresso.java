package com.example.demo.design.decorate;

/**
 * @description: 蒸馏咖啡
 * @author: Grace.Pan
 * @create: 2020-03-16 20:48
 */
public class Espresso extends Beverage {

    public Espresso(){
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
