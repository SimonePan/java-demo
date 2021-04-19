package com.example.demo.qlexpress;


import com.example.rules.domain.QLExpressDO;
import com.example.rules.domain.QLRuleDO;
import com.example.rules.helper.ExpressHelper;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2021-03-18 10:47
 */
public class QLExpressHelperTest {

    @Test
    public void qlExpress_long_dec_ql_addOp() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, true);
        runner.addFunctionOfClassMethod("向上取整", ExpressHelper.class.getName(),
                "upRode", new Class[]{BigDecimal.class}, null);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("c", new BigDecimal("0.1263"));
        String express = "向上取整(c)";
        Object r = runner.execute(express, context, null, true, true);
        Assert.assertEquals(r, 1L);
    }

    @Test
    public void qlExpress_long_dec_ql_addOp_dec() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, true);
        runner.addFunctionOfClassMethod("向上取整", ExpressHelper.class.getName(),
                "upRode", new Class[]{BigDecimal.class}, null);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a", new BigDecimal(Long.parseLong("100")));
        context.put("b", new BigDecimal(Long.parseLong("9")));
        context.put("c", new BigDecimal("0.1263"));
        context.put("d", 2);
        String express = "向上取整((a-b)*c)*d";
        Object r = runner.execute(express, context, null, true, true);
        Assert.assertEquals(r, 24L);
    }

    @Test
    public void qlExpress_supplierIncome_text() throws Exception {
        // 供应商收入 = ((成本价 - 限时折扣) * 成本折扣) * 数量 + 总税费 - 优惠券 + 运费 +自营商品平台返点 - 折扣领样优惠金额
        ExpressRunner runner = new ExpressRunner(false, true);
        runner.addFunctionOfClassMethod("向上取整", ExpressHelper.class.getName(),
                "upRode", new Class[]{BigDecimal.class}, null);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("成本价", 100L);
        context.put("限时折扣", 1L);
        context.put("成本折扣", new BigDecimal("0.1234"));
        context.put("数量", 2);
        context.put("总税费", 2L);
        context.put("优惠券", 10L);
        context.put("运费", 8L);
        context.put("自营商品平台返点", 4L);
        context.put("折扣领样优惠金额", 0L);
        String express = "向上取整(((成本价 - 限时折扣) * 成本折扣)) * 数量 + 总税费 - 优惠券 + 运费 + 自营商品平台返点 - 折扣领样优惠金额";
        Object r = runner.execute(express, context, null, true, true);
        // (100-1)*0.1234=12.2166=13
        // 13*2+2-10+8+4-0=30
        Assert.assertEquals(r, 30L);
        String text = express;
        for (Map.Entry<String, Object> entry : context.entrySet()) {
            text = text.replaceAll(entry.getKey(), entry.getKey() + context.get(entry.getKey()));
        }
        System.out.println("供应商收入=" + text);
    }

    @Test
    public void qlExpress_platformServiceFee() throws Exception {
        // 平台服务费	(主播等级折扣默认=1）
        // 1. 含单品费率：平台服务费计费基数*品牌商倍率*单品服务费率
        // 2. 其他：平台服务费计费*品牌商倍率*货源商品类目费率* 主播等级折扣

        // 平台服务费计费基数
        // 1. B端成本价购买: 售价*数量
        // 2. C端购买/B端原价购买: (售价-限时折扣)* 数量 - 优惠券
        boolean buyAtCost = false;
        String platformBaseExpress = "(售价-限时折扣)* 数量 - 优惠券";
        if (buyAtCost) {
            platformBaseExpress = "售价*数量";
        }

        ExpressRunner runner = new ExpressRunner(false, true);
        // 宏
        runner.addMacro("平台服务费计费基数", platformBaseExpress);

        // 自定义函数
        runner.addFunctionOfClassMethod("向上取整", ExpressHelper.class.getName(),
                "upRode", new Class[]{BigDecimal.class}, null);
        runner.addFunctionOfClassMethod("存在", ExpressHelper.class.getName(),
                "exist", new Class[]{BigDecimal.class}, null);

        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("售价", 100L);
        context.put("限时折扣", 1L);
        context.put("数量", 2);
        context.put("优惠券", 10L);
        context.put("单品服务费率", new BigDecimal("0.0123"));
        context.put("品牌商倍率", new BigDecimal("0.7777"));
        context.put("货源商品类目费率", new BigDecimal("0.0555"));
        context.put("主播等级折扣", BigDecimal.ONE);
        String express = "if 存在(单品服务费率) then {return 向上取整(平台服务费计费基数*品牌商倍率*单品服务费率);} else {return " +
                "向上取整(平台服务费计费基数*品牌商倍率*货源商品类目费率*主播等级折扣);}";
        Object r = runner.execute(express, context, null, true, true);
        // (100-1)*2-10=188
        // 188*0.7777*0.0123=1.798353=2
        Assert.assertEquals(r, 2L);
        String text = express;
        String platformBaseText = platformBaseExpress;
        for (Map.Entry<String, Object> entry : context.entrySet()) {
            text = text.replaceAll(entry.getKey(), entry.getKey() + context.get(entry.getKey()));
            platformBaseText = platformBaseText.replaceAll(entry.getKey(), entry.getKey() + context.get(entry.getKey()));
        }
        System.out.println("平台服务费计费基数=" + platformBaseText);
        System.out.println("平台服务费=" + text);
    }

    @Test
    public void qlExpress_platformServiceFee_2() throws Exception {
        // todo 多个费用的依赖维护

        QLExpressDO platformFee = new QLExpressDO();
        platformFee.setName("平台服务费");
        platformFee.setRules(getPlatformFeeRuleList());
        platformFee.setWeight(9);

        QLExpressDO platformBase = new QLExpressDO();
        platformBase.setName("平台服务费计费基数");
        platformBase.setRules(getPlatformBaseRuleList());
        platformBase.setWeight(1);

        HashMap<String, QLExpressDO> map = new HashMap<>();
        map.put(platformFee.getName(), platformFee);
        map.put(platformBase.getName(), platformBase);


        // 执行规则
        ExpressRunner runner = new ExpressRunner(false, true);
        // 自定义函数
        runner.addFunctionOfClassMethod("向上取整", ExpressHelper.class.getName(),
                "upRode", new Class[]{BigDecimal.class}, null);
        runner.addFunctionOfClassMethod("存在", ExpressHelper.class.getName(),
                "exist", new Class[]{BigDecimal.class}, null);

        // 上下文
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("成本价购买", false);
        context.put("售价", 100L);
        context.put("限时折扣", 1L);
        context.put("数量", 2);
        context.put("优惠券", 10L);
        context.put("单品服务费率", new BigDecimal("0.0123"));
        context.put("品牌商倍率", new BigDecimal("0.7777"));
        context.put("货源商品类目费率", new BigDecimal("0.0555"));
        context.put("主播等级折扣", BigDecimal.ONE);

        // 多规则时获取符合条件的最终规则
        String execBaseExpress = getFinalExpress(getPlatformBaseRuleList(), runner, context);
        // 执行最终规则
        Object base = runner.execute(execBaseExpress, context, null, true, true);
        context.put("平台服务费计费基数", base);

        // 多规则时获取符合条件的最终规则
        String execExpress = getFinalExpress(getPlatformFeeRuleList(), runner, context);

        // 执行最终规则
        Object r = runner.execute(execExpress, context, null, true, true);
        Assert.assertEquals(r, 2L);

        String text = getExpressText(execExpress, context);
        String baseText = getExpressText(execBaseExpress, context);
        System.out.println("平台服务费计费基数=" + baseText);
        System.out.println("平台服务费=" + text);
    }

    /**
     * 获取最终公式
     *
     * @param expressDOList
     * @param runner
     * @param context
     * @return
     * @throws Exception
     */
    public String getFinalExpress(List<QLRuleDO> expressDOList, ExpressRunner runner, DefaultContext<String, Object> context) throws Exception {
        //根据权重排序
        List<QLRuleDO> sortedExpressList = expressDOList.stream().sorted().collect(Collectors.toList());

        // 多规则时获取符合条件的最终规则
        String result = null;
        for (QLRuleDO expressDO : sortedExpressList) {
            boolean cr = (Boolean) runner.execute(expressDO.getCondition(), context, null, true, true);
            if (cr) {
                result = expressDO.getExpress();
                break;
            }
        }
        if (result == null) {
            throw new Exception("规则缺失");
        }
        return result;
    }

    /**
     * 获取公式内容
     *
     * @param express
     * @param context
     * @return
     */
    public String getExpressText(String express, DefaultContext<String, Object> context) {
        String baseText = express;
        for (Map.Entry<String, Object> entry : context.entrySet()) {
            baseText = baseText.replaceAll(entry.getKey(), entry.getKey() + context.get(entry.getKey()));
        }
        return baseText;
    }

    /**
     * 平台服务费计费基数
     *
     * @return
     */
    public List<QLRuleDO> getPlatformBaseRuleList() {
        // 平台服务费计费基数 规则
        // 1. B端成本价购买: 售价*数量
        // 2. C端购买/B端原价购买: (售价-限时折扣)* 数量 - 优惠券
        List<QLRuleDO> baseRules = new ArrayList<>();
        QLRuleDO defaultBaseRate = new QLRuleDO();
        defaultBaseRate.setWeight(9);
        defaultBaseRate.setCondition("true");
        defaultBaseRate.setExpress("(售价-限时折扣)* 数量 - 优惠券");
        baseRules.add(defaultBaseRate);

        QLRuleDO buyAtCost = new QLRuleDO();
        buyAtCost.setWeight(1);
        buyAtCost.setCondition("成本价购买");
        buyAtCost.setExpress("售价*数量");
        baseRules.add(buyAtCost);
        return baseRules;
    }

    /**
     * @return
     */
    public List<QLRuleDO> getPlatformFeeRuleList() {
        // 规则
        List<QLRuleDO> expressDOList = new ArrayList<>();
        QLRuleDO defaultRate = new QLRuleDO();
        defaultRate.setWeight(9);
        defaultRate.setCondition("true");
        defaultRate.setExpress("向上取整(平台服务费计费基数*品牌商倍率*单品服务费率)");
        expressDOList.add(defaultRate);

        QLRuleDO itemRate = new QLRuleDO();
        itemRate.setWeight(1);
        itemRate.setCondition("存在(单品服务费率)");
        itemRate.setExpress("向上取整(平台服务费计费基数*品牌商倍率*单品服务费率)");
        expressDOList.add(itemRate);
        return expressDOList;
    }
}