package com.example.rules.domain;

import lombok.Data;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2021-03-18 16:24
 */
@Data
public class QLRuleDO implements Comparable<QLRuleDO> {
    /**
     * 权重
     */
    private Integer weight;
    /**
     * 条件
     */
    private String condition;
    /**
     * 执行语句/公式
     */
    private String express;

    @Override
    public int compareTo(QLRuleDO o) {
        if (this.getWeight() > o.getWeight()) {
            return 1;
        }
        if (this.getWeight() < o.getWeight()) {
            return -1;
        }
        return 0;
    }
}
