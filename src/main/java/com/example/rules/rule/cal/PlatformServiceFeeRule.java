package com.example.rules.rule.cal;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.math.BigDecimal;

/**
 * @description: PlatformServiceFeeRule
 * @author: Grace.Pan
 * @create: 2021-04-01 15:28
 */
@Rule(name = "平台服务费规则", description = "如果有单品服务费率，则服务费率为单品")
public class PlatformServiceFeeRule {

    /**
     * 硬编码条件
     * @return
     */
    @Condition
    public boolean when(@Fact("param")DistributionFeeParamDTO param){
        return param.getItemServiceRate()!=null&&param.getItemServiceRate().compareTo(BigDecimal.ZERO)!=0;
    }

    /**
     * 硬编码条件
     * @return
     */
    @Action
    public void then(DistributionFeeParamDTO param){

    }

}
