package com.scaffolding.pojo.vo.order.detail;

import com.scaffolding.global.style.SpecialStyle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: yt
 * @Date: 2021/04/29/13:49
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderMoneyVO implements Serializable {

    private static final long serialVersionUID = 3656203478098464606L;
    /**
     * 金额类型(订单金额/运费/优惠金额/实付金额/退款金额)
     */
    private Integer moneyType;
    private String moneyName;
    /**
     * 金额数值字符串
     */
    private BigDecimal money;
    /**
     * 金额数值字符串
     */
    private String moneyStr;
    /**
     * 符号
     */
    private String symbol;
    /**
     * 货币
     */
    private String currency;
    /**
     * 样式
     */
    private SpecialStyle specialStyle;
    /**
     * 排序
     */
    private Integer sort;

}
