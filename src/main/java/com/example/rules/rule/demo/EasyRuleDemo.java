package com.example.rules.rule.demo;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.InferenceRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2021-03-19 11:35
 */
public class EasyRuleDemo {

    public static void main(String[] args) {
        // 1. 定义规则
        Rules rules = new Rules();
        rules.register(new MyRule());

        // 2. 定义事实
        Facts facts = new Facts();
        facts.put("fact", true);

        // 3. 创建一个规则引擎
        //    配置规则引擎
        RulesEngineParameters parameters = new RulesEngineParameters()
                .skipOnFirstAppliedRule(true) // 规则被触发时跳过后面的规则
                .skipOnFirstFailedRule(true) //在规则失败时跳过后面的规则
                .skipOnFirstNonTriggeredRule(false); // 规则未触发则跳过后面的规则

        //    DefaultRulesEngine: 根据规则的自然顺序（默认为优先级）应用规则
        RulesEngine defaultRulesEngine = new DefaultRulesEngine(parameters);
        //    InferenceRulesEngine: 持续对已知事实应用规则，直到不再应用规则为止。
        RulesEngine inferenceRulesEngine = new InferenceRulesEngine(parameters);
        // 如果优先级超过定义的阈值，则跳过下一个规则
        defaultRulesEngine.getParameters().setPriorityThreshold(10);

        // 4. 触发注册规则
        defaultRulesEngine.fire(rules, facts);

    }

}
