package com.example.demo.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Grace.Pan
 * @date 2019/6/24
 */
@AllArgsConstructor
@Getter
@Setter
public class Animal {

    private String name;
    private Boolean show;

    private List<String> skill;

    public List<String> getSkill() {
        return skill;
    }

    public String getName() {
        return name;
    }
}
