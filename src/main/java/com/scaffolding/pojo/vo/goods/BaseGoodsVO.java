package com.scaffolding.pojo.vo.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/05/31/11:08
 * @Description: 商品基础信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private String mtrlSpecs;
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
    private String mtrlNo;
}
