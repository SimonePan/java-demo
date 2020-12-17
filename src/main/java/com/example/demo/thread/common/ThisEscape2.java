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
public class ThisEscape2 {
    private Long id;
    /**
     * 不要在构造过程中使this引用逸出：即使把发布对象的语句放在最后一行，也是不可取的。
     *
     * @param id
     */
    public ThisEscape2(Long id) {
        // 发布内部类，隐含外部类的this引用
        this.id=id;
        new Thread(()-> printName()).run();
    }

    public ThisEscape2(EventSource eventSource,Long id) {
        // 发布内部类，隐含外部类的this引用
        this.id=id;
        new Thread(()-> {
            eventSource.setThisEscape(this);
            eventSource.printName();
        }).run();
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
        ThisEscape2 thisEscape1 = new ThisEscape2(1L);
    }
}
