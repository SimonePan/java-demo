package com.example.demo.thread.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2020-01-06 14:12
 */
@Slf4j
public class EventSource {
    private ThisEscape.Inner inner;
    public void printName(ThisEscape.Inner inner) {
        this.inner = inner;
        log.info(this.inner.getName());
    }
    public void printName() {
        log.info(inner.getName());
    }
}
