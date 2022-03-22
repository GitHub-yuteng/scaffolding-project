package com.scaffolding.pojo.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/25 11:09 上午
 */
@Data
public class ProductBean implements Serializable {

    public Long id;
    public String spuCode;
    public String skuCode;
    public String materialCode;
    /**
     * 商品名称
     */
    public String material;
    /**
     * 单位
     */
    public String unit;
    /**
     * 缩略图
     */
    public String picPath;
    /**
     * 毫升
     */
    public String milliliter;
    /**
     * 味道
     */
    public String taste;
    /**
     * 规格
     */
    public String specification;
    /**
     * 单价
     */
    public BigDecimal unitPrice;
    /**
     * 划线价
     */
    private String markPrice;
    /**
     * 店铺归属
     */
    public Long storeId;
}