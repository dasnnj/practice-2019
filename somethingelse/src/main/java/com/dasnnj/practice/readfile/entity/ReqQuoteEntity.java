package com.dasnnj.practice.readfile.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * 请求报价的Quote报文
 */
@Getter
@Setter
public class ReqQuoteEntity extends BasicQuote {

    /** 市场类型 */
    private String marketIndicator;

    /** 报价类别 */
    private String quoteType;

    /** 操作类型 */
    private String quoteTransType;

    /** 报价状态 */
    private String quoteStatus;

    /** 报价有效时间 */
    private String validUntilTime;

    /** 客户参考编号 */
    private String clOrdID;

    /** 查询请求编号 */
    private String queryRequestID;

    /** 原客户参考编号 */
    private String origClordID;

    /** 报价请求编号 */
    private String quoteReqID;

    /** 请求回复编号 */
    private String quoteID;

    /** 业务发生时间 */
    private String transactTime;

    /** 应急标识 */
    private String contingencyIndicator;

    /** 匿名标识 */
    private String anonymousIndicator;

    /** 债券代码 */
    private String securityID;

    /** 债券名称 */
    private String symbol;

    /** 交易方向 */
    private String side;

    /** 净价 */
    private String price;

    /** 全价 */
    private String dirtyPrice;

    /** 应计利息 */
    private String accruedInterestAmt;

    /** 应计利息总额 */
    private String accruedInterestTotalAmt;

    /** 劵面总额 */
    private String orderQty;

    /** 交易金额 */
    private String tradeCashAmt;

    /** 结算金额 */
    private String settlCurrAmt;

    /** 结算币种 */
    private String settlCurrency;

    /** 汇率 */
    private String settlCurrFxRate;

    /** 结算方式 */
    private String deliveryType;

    /** 清算类型 */
    private String clearingMethod;

    /** 清算速度 */
    private String settlType;

    /** 结算日 */
    private String settlDate;

    /** 每百元本金额 */
    private String principal;

    /** 本金额 */
    private String totalPrincipal;

    /** 到期收益率 */
    private String yield;

    /** 行权收益率 */
    private String strikeYield;

    /** 做市方交易账户21位码 */
    private String initPartyID;

    /** 做市方交易员ID */
    private String initPartyTradeCode;


    //quoteID是请求回复编号，区分不同的请求回复

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReqQuoteEntity that = (ReqQuoteEntity) o;
        return Objects.equals(quoteID, that.quoteID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quoteID);
    }

    //下面的是请求报价编号，用来区分不同的请求报价
    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReqQuoteEntity that = (ReqQuoteEntity) o;

        return quoteReqID.equals(that.quoteReqID);

    }

    @Override
    public int hashCode() {
        return quoteReqID.hashCode()
    }*/
}