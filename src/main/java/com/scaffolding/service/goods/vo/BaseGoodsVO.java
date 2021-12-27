package com.scaffolding.service.goods.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2021/12/27 4:43 下午
 */
@Data
public class BaseGoodsVO implements Serializable {

    /**
     * Sku图片
     */
    private String picPath;
    /**
     * 商品编码
     */
    private String skuCode;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 味道
     */
    private String taste;
    /**
     * 1*24类似信息
     */
    private String specs;
    /**
     * 毫升
     */
    private String ml;
    /**
     * 单位
     */
    private String unit;
    /**
     * spu
     */
    private String spuCode;
    /**
     * 商品代码
     */
    private String internalCode;
}
