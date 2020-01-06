package com.example.demo.thread.common;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: this逸出
 * @author: Grace.Pan
 * @create: 2020-01-03 15:46
 */
@Slf4j
@Getter
@Setter
public class ThisEscape {
    private Long id;
    /**
     * 不要在构造过程中使this引用逸出：即使把发布对象的语句放在最后一行，也是不可取的。
     *
     * @param eventSource
     * @param id
     */
    public ThisEscape(EventSource eventSource, Long id) {
        // 发布内部类，隐含外部类的this引用
        eventSource.printName(new Inner());
        this.id = id;
    }
    class Inner {
        String getName() {
            return id + "-inner-name";
        }
    }
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        ThisEscape thisEscape = new ThisEscape(eventSource, 1L);
        eventSource.printName();
    }
}
