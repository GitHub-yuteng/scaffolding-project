package com.scaffolding.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Vm
 * @since 2022-03-09 14:33:21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("hxh_order_detail")
public class HxhOrderDetailEntity {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 商品序号
     */
    private Integer itemNo;

    /**
     * 商品状态
     */
    private Integer productStatus;

    /**
     * 店铺id
     */
    private Long storeId;

    private String spuCode;

    private String skuCode;

    private String materialCode;

    /**
     * 单位
     */
    private String unit;

    private BigDecimal unitPrice;

    /**
     * 数量
     */
    private Integer buyNum;

    /**
     * 商品单价*数量=总金额
     */
    private BigDecimal productAmount;

    /**
     * 优惠总金额
     */
    private BigDecimal discountAmount;

    /**
     * 商品分摊运费
     */
    private BigDecimal freightAmount;

    /**
     * 实际支付金额
     */
    private BigDecimal payAmount;
    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

    /**
     * 发货数量
     */
    private Integer deliverNum;

    /**
     * 收货数量
     */
    private Integer receiveNum;

    /**
     * 售后数量
     */
    private Integer refundNum;

    /**
     * 售后次数
     */
    private Integer refundTimes;

    /**
     * 售后拒绝次数
     */
    private Integer refuseTimes;

    /**
     * 10:普通商品 20:赠品
     */
    private Integer productType;

    private String discountDetails;

    private BigDecimal couponAmount;

    private BigDecimal activityAmount;

    private BigDecimal pointAmount;

    /**
     * 积分(哈币)消耗
     */
    private Integer pointExpend;

    /**
     * 分享人 用户id
     */
    private Long shareId;

    /**
     * 操作人
     */
    private String operBy;

    private LocalDateTime operTime;

}
