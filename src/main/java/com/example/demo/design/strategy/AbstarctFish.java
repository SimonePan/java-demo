package com.example.demo.design.strategy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 抽象鱼
 * @author: Grace.Pan
 * @create: 2020-03-12 15:15
 */
@Data
@Slf4j
public class AbstarctFish {
    private String name;

    private String gender;

    public void swim() {
        log.info("{} is swimming...", this.name);
    }
}
