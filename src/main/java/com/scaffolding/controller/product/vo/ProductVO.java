package com.scaffolding.controller.product.vo;

import com.whhim.hxh.pojo.bean.ProductBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductVO extends ProductBean {

    /**
     * 当前spu下价格最低的商品价格
     */
    private String showPrice;
    /**
     * 佣金
     */
    private BigDecimal commissions;

    private Integer buyCount;
    /**
     * 最小购买数量
     */
    private Integer minPurchase;
    /**
     * 最大购买数量
     */
    private Integer maxPurchase;
    /**
     * 上下架 0:未知 1:上架 2:下架
     */
    private Integer onShelf;
}