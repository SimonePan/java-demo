package com.example.demo.thread.common;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.FutureTask;

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

    public ThisEscape(Long id) {
        this.id = id;
        //
        new Thread(this::printName).run();
    }

    class Inner {
        String getName() {
            return id + "-inner-name";
        }
    }
    public void printName() {
        log.info("ThisEscape.id="+id);
    }
    public static void main(String[] args) {
        /*EventSource eventSource = new EventSource();
        ThisEscape thisEscape = new ThisEscape(eventSource, 1L);
        eventSource.printName();*/
        ThisEscape thisEscape1 = new ThisEscape(1L);
        thisEscape1.printName();

    }
}
