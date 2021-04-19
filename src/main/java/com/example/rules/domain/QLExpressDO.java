package com.example.rules.domain;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2021-03-18 16:24
 */
@Data
public class QLExpressDO implements Comparable<QLExpressDO> {
    /**
     * id
     */
    private Long id;
    /**
     * 名称（唯一）
     */
    private String name;
    /**
     * 权重
     */
    private Integer weight;
    /**
     * 执行语句/公式
     */
    private List<QLRuleDO> rules;

    @Override
    public int compareTo(QLExpressDO o) {
        if (this.getWeight() > o.getWeight()) {
            return 1;
        }
        if (this.getWeight() < o.getWeight()) {
            return -1;
        }
        return 0;
    }
}
