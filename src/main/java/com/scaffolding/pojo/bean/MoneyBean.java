package com.scaffolding.pojo.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: yt
 * @Date: 2021/04/29/13:49
 * @Description:
 */
@Data
public class MoneyBean implements Serializable {

    private static final long serialVersionUID = 3656203478098464606L;
    /**
     * 金额类型(订单金额/运费/优惠金额/实付金额/退款金额)
     */
    public Integer moneyType;
    public String moneyName;
    /**
     * 金额数值
     */
    public BigDecimal money;
    /**
     * 金额数值字符串
     */
    public String moneyStr;
    /**
     * 符号
     */
    public String symbol;
    /**
     * 货币
     */
    public String currency;
    /**
     * 排序
     */
    public Integer sort;

    public MoneyBean() {
    }

    public MoneyBean(Integer moneyType, String moneyName, BigDecimal money, String moneyStr, String symbol, String currency, Integer sort) {
        this.moneyType = moneyType;
        this.moneyName = moneyName;
        this.money = money;
        this.moneyStr = moneyStr;
        this.symbol = symbol;
        this.currency = currency;
        this.sort = sort;
    }
}
