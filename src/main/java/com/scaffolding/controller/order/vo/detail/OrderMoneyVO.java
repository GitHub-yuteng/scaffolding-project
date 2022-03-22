package com.scaffolding.controller.order.vo.detail;

import com.whhim.hxh.pojo.bean.MoneyBean;

import java.math.BigDecimal;


/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/2 8:31 上午
 */
public class OrderMoneyVO extends MoneyBean {

    public OrderMoneyVO() {
    }

    public OrderMoneyVO(Integer moneyType, String moneyName, BigDecimal money, String moneyStr, String symbol, String currency, Integer sort) {
        super(moneyType, moneyName, money, moneyStr, symbol, currency, sort);
    }
}
