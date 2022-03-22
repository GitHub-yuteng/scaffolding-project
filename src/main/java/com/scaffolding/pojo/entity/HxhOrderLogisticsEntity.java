package com.scaffolding.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 订单物流信息表
 * </p>
 *
 * @author Vm
 * @since 2022-02-25 10:12:17
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("hxh_order_logistics")
public class HxhOrderLogisticsEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 包裹Json [{"skuCode":"xxxx","deliveryNum":xx}]
     */
    private Integer packageNo;

    private String packageInfo;

    /**
     * 发货时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 1:快递物流
     */
    private Integer deliveryType;

    /**
     * 快递公司代码
     */
    private String expressCode;

    /**
     * 快递公司名称
     */
    private String expressName;

    /**
     * 物流单号
     */
    private String logisticsNo;

    private String deliveryBy;

    /**
     * -1:追回失败 0:无需追回 1: 申请追回 2: 已追回 
     */
    private Integer ifBack;

    private String storeId;

    /**
     * 是否代发
     */
    private Boolean ifProxy;

    private LocalDateTime operTime;

    /**
     * 1:未删除 0:删除
     */
    private Integer isDeleted;


}
