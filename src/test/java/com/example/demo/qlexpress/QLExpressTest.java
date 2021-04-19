package com.example.demo.qlexpress;
import com.example.rules.domain.QLRuleDO;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.exception.QLException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Grace.Pan
 * @create: 2021-03-18 10:47
 */
public class QLExpressTest {

    @Test
    public void qlExpress_bigDecimal() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, true);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("成本价", new BigDecimal("100"));
        context.put("限时折扣", new BigDecimal("9"));
        context.put("成本折扣", new BigDecimal("0.1263"));
        String express = "(成本价 - 限时折扣) * 成本折扣";
        BigDecimal r = (BigDecimal) runner.execute(express, context, null, true, true);
        System.out.println("r=" + r);
        Assert.assertEquals(r, new BigDecimal("11.4933"));
    }

    @Test
    public void qlExpress_long_dec() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, true);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("成本价", Long.valueOf("100"));
        context.put("限时折扣", Long.valueOf("9"));
        context.put("成本折扣", new BigDecimal("0.1263"));
        String express = "(成本价 - 限时折扣) * 成本折扣";
        BigDecimal r = (BigDecimal) runner.execute(express, context, null, true, true);
        Assert.assertEquals(r, new BigDecimal("11.4933"));
    }

    @Test
    public void qlExpress_long_dec_1() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, true);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("成本价", Long.valueOf("100"));
        context.put("限时折扣", Long.valueOf("9"));
        context.put("成本折扣", new BigDecimal("1"));
        String express = "(成本价 - 限时折扣) * 成本折扣";
        BigDecimal r = (BigDecimal) runner.execute(express, context, null, true, true);
        Assert.assertEquals(r, new BigDecimal("91"));
    }

    @Test
    public void qlExpress_long_dec_one() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, true);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("成本价", Long.valueOf("100"));
        context.put("限时折扣", Long.valueOf("9"));
        context.put("成本折扣", BigDecimal.ONE);
        String express = "(成本价 - 限时折扣) * 成本折扣";
        BigDecimal r = (BigDecimal) runner.execute(express, context, null, true, true);
        Assert.assertEquals(r, new BigDecimal("91"));
    }

    @Test
    public void qlExpress_long_dec_java() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, true);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a", new BigDecimal(Long.parseLong("100")));
        context.put("b", new BigDecimal(Long.parseLong("9")));
        context.put("c", new BigDecimal("0.1263"));
        String express = "(a.subtract(b)).multiply(c)";
        Object r = runner.execute(express, context, null, true, true);
        Assert.assertEquals(r, new BigDecimal("11.4933"));
    }

    @Test
    public void qlExpress_long_dec_ql() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, true);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a", new BigDecimal(Long.parseLong("100")));
        context.put("b", new BigDecimal(Long.parseLong("9")));
        context.put("c", new BigDecimal("0.1263"));
        String express = "(a-b)*c";
        Object r = runner.execute(express, context, null, true, true);
        Assert.assertEquals(r, new BigDecimal("11.4933"));
    }

    /**
     * 赋值时候，类型转换错误：java.math.BigDecimal 不能转换为 long
     *
     * @throws Exception
     */
    @Test(expected = QLException.class)
    public void qlExpress_long_dec_ql_change() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, true);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a", new BigDecimal(Long.parseLong("100")));
        context.put("b", new BigDecimal(Long.parseLong("9")));
        context.put("c", new BigDecimal("0.1263"));
        String express = "long r = (a-b)*c; return e;";
        Object r = runner.execute(express, context, null, true, true);
    }

    @Test
    public void qlExpress_long_dec_ql_addOp_abs() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, true);
        runner.addFunctionOfClassMethod("取绝对值", Math.class.getName(), "abs",
                new String[]{"double"}, null);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a", new BigDecimal(Long.parseLong("-100")));
        String express = "取绝对值(a)";
        Object r = runner.execute(express, context, null, true, true);
        Assert.assertEquals(r, 100);
    }

    @Test
    public void qlExpress_true() throws Exception {
        ExpressRunner runner = new ExpressRunner(false, true);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        String express = "true";
        Boolean r = (Boolean) runner.execute(express, context, null, true, true);
        Assert.assertTrue(r);
    }


    @Test
    public void qlExpress_sorted() throws Exception {
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

        QLRuleDO itemRate1 = new QLRuleDO();
        itemRate1.setWeight(3);
        itemRate1.setCondition("存在(单品服务费率)");
        itemRate1.setExpress("向上取整(平台服务费计费基数*品牌商倍率*单品服务费率)");
        expressDOList.add(itemRate1);

        //todo 根据权重排序
        List<QLRuleDO> sortedExpressList = expressDOList.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedExpressList);
    }


}