package com.scaffolding.controller.order.vo;

import com.whhim.hxh.pojo.bean.ProductBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/28 3:22 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderProductVO extends ProductBean {

    private Integer itemNo;
    /**
     * 商品数量
     */
    private Integer buyCount;
    private OrderLabelVO productLabel;
    private OrderButtonVO productBtn;
}
