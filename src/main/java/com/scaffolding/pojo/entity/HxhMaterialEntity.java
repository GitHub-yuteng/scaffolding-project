package com.scaffolding.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author Vm
 * @since 2022-03-11 09:38:19
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("hxh_material")
public class HxhMaterialEntity {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String spuCode;

    private String skuCode;

    private String materialCode;

    /**
     * 物料
     */
    private String material;

    /**
     * 单位
     */
    private String unit;

    /**
     * 毫升
     */
    private String milliliter;

    /**
     * 规格
     */
    private String specification;

    /**
     * 味道
     */
    private String taste;

    private String picPath;

    /**
     * 0:未知 1:上架 2:下架
     */
    private Integer onShelf;

    /**
     * 1:娃哈哈店铺（默认）
     */
    private Long storeId;

    private String keyWord;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    private Integer minPurchase;

    private Integer maxPurchase;

    private String markPrice;

    /**
     * 佣金
     */
    private BigDecimal commissions;


}
