package com.example.demo.design.strategy;

/**
 * @description: 假鱼: 不会游泳
 * @author: Grace.Pan
 * @create: 2020-03-12 15:15
 */
public class FakeFish extends AbstarctFish{
    // 方法1(不推荐）：重写AbstarctFish.swim

    // 方法2（推荐）：把非共性的行为抽离开，每个行为一个接口，具体的个性化行为实现该接口。使用组合方式。


}
