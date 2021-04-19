package com.example.rules.rule.demo;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2021-03-19 11:35
 */
@Rule(name = "my rule", description = "my rule description", priority = 1)
public class MyRule {

    @Condition
    public boolean evaluate(@Fact("fact") boolean fact) {
        //my rule conditions
        return fact;
    }

    @Action(order = 1)
    public void execute(Facts facts) throws Exception {
        //my actions
        System.out.println("MyRule facts="+facts);
    }

}
