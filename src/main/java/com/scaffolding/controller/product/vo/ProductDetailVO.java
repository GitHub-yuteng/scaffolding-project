package com.scaffolding.controller.product.vo;

import com.whhim.hxh.controller.product.vo.attr.ProductAttributeVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/3 10:51 上午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDetailVO extends ProductVO {

    /**
     * 数量
     */
    private Integer selectNum;
    /**
     * 商详轮播图
     */
    private List<String> rotationUrlList;
    /**
     * 活动倒计时
     */
    private Long countDownTime;
    /**
     * 口味 规格
     */
    private List<ProductAttributeVO> productAttributeList;
    /**
     * 商品详情
     */
    private List<String> detailUrlList;
    /**
     * 按钮
     */
    private List<ProductButtonVO> bottomBtnList;

    private Long shareId;

    /**
     * sku 对应的基本信息
     */
    private Map<String,ProductVO> skuInfoMap;

}
