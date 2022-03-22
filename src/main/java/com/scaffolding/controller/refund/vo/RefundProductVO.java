package com.scaffolding.controller.refund.vo;

import com.whhim.hxh.pojo.bean.ProductBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/4 10:28 上午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RefundProductVO extends ProductBean {

    /**
     * 退款金额
     */
    private String refundAmount;
    /**
     * 可以申请的最大数量
     */
    private Integer applyMax;

}
