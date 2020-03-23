package com.example.demo.design.decorate;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2020-03-16 20:52
 */
public class Demo {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription()+":"+espresso.cost());
        Beverage houseBlend = new HouseBlend();
        System.out.println(houseBlend.getDescription()+":"+houseBlend.cost());
        houseBlend = new Milk(houseBlend);
        houseBlend = new Milk(houseBlend);
        houseBlend = new Mocha(houseBlend);
        System.out.println(houseBlend.getDescription()+":"+houseBlend.cost());
    }
}
