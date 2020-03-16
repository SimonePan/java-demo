package com.example.demo.design.strategy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 鱼
 * @author: Grace.Pan
 * @create: 2020-03-11 14:48
 */
@Data
@Slf4j
public class Fish {
    private String name;

    private String gender;

    public void swim() {
        log.info("{} is swimming...", this.name);
    }

    /**
     * 吐泡泡
     */
    public void spitBubbles() {
        log.info("{} is spit Bubbles...", this.name);
    }
}
