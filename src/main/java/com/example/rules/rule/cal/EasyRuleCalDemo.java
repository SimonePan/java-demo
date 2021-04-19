package com.example.rules.rule.cal;

import com.example.rules.rule.demo.MyRule;
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
public class EasyRuleCalDemo {

    public static void main(String[] args) {
        // 1. 定义规则
        Rules rules = new Rules();
        rules.register(new PlatformServiceFeeRule());

        // 2. 定义事实
        Facts facts = new Facts();
        facts.put("param", new DistributionFeeParamDTO());

        // 3. 创建一个规则引擎
        //    DefaultRulesEngine: 根据规则的自然顺序（默认为优先级）应用规则
        RulesEngine engine = new DefaultRulesEngine();

        // 4. 触发注册规则
        engine.fire(rules, facts);
    }

}
