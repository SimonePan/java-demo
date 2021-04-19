package com.example.rules.rule.cal;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description: 分佣费用
 * @author: Grace.Pan
 * @create: 2020-02-27 11:57
 */
@Data
public class DistributionFeeParamDTO implements Serializable {
    private static final long serialVersionUID = -4830629760373787120L;
    /**
     * 平台补贴费率
     */
    private BigDecimal extraCommissionRate;
    /**
     * 品牌商倍率
     */
    private BigDecimal brandMultiplierRate;
    /**
     * 货源类目费率
     */
    private BigDecimal platformServiceRate;
    /**
     * 渠道费率
     */
    private BigDecimal thirdServiceRate;
    /**
     * 自营商品退费率
     */
    private BigDecimal selfItemRebateRate;
    /**
     * 成本价折扣率
     */
    private BigDecimal costPriceRate;
    /**
     * 总税费
     */
    private Long totalTaxFee;
    /**
     * 运费
     */
    private Long deliveryFee;
    /**
     * f
     * 单件限时折扣金额
     */
    private Long unitLimitDiscountAmount;
    /**
     * 单件售价
     */
    private Long unitPrice;
    /**
     * 单件成本价
     */
    private Long costPrice;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 优惠券金额
     */
    private Long coupon;
    /**
     * 订单支付金额
     */
    private Long paymentAmount;
    /**
     * 佣金特例配置ID
     */
    private Long starSpecialServiceId;
    /**
     * 配置用户ID
     */
    private Long configUserId;
    /**
     * 配置用户ID
     */
    private Integer channel;
    /**
     * 主播等级折扣
     */
    private BigDecimal memberGradeRate;
    /**
     * 商品类型 DistributionItemTypeEnum
     */
    private Integer type;
    /**
     * 单品服务费率
     */
    private BigDecimal itemServiceRate;
    /**
     * 会员等级
     */
    private Integer memberGrade;
    /**
     * 限时领样折扣金额
     */
    private Long limitSampleDiscountAmount;
    /**
     * 总共可分配金额
     */
    private Long totalDistributionAmount;
    /**
     * 订单金额
     */
    private Long orderTotalAmount;
    /**
     * 商品金额
     */
    private Long itemTotalAmount;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * cps佣金
     */
    private Long cpsFee;

    public void setDefault() {
        if (this.getUnitLimitDiscountAmount() == null) {
            this.setUnitLimitDiscountAmount(0L);
        }
        if (this.getTotalTaxFee() == null) {
            this.setTotalTaxFee(0L);
        }
        if (this.getDeliveryFee() == null) {
            this.setDeliveryFee(0L);
        }
        if (this.getCoupon() == null) {
            this.setCoupon(0L);
        }
        if (this.getNumber() == null) {
            this.setNumber(1);
        }
        if (this.getBrandMultiplierRate() == null) {
            this.setBrandMultiplierRate(new BigDecimal("1"));
        }
        if (this.getCostPriceRate() == null) {
            this.setCostPriceRate(new BigDecimal("1"));
        }
        if (this.getLimitSampleDiscountAmount() == null) {
            this.setLimitSampleDiscountAmount(0L);
        }
    }


}
