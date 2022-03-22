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
 * @since 2022-03-01 19:22:58
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("hxh_order")
public class HxhOrderEntity {

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
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 买方代码
     */
    private String buyerCode;

    /**
     * 下单联系人
     */
    private String contacts;

    /**
     * 下单手机号
     */
    private String telephone;

    /**
     * 店铺id
     */
    private Long storeId;

    /**
     * 1:安卓 2:IOS 3:微信小程序
     */
    private String platformSource;

    /**
     * 支付方式
     */
    private String payPattern;

    /**
     * 0:未支付 1:已支付
     */
    private Integer payStatus;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 优惠总金额
     */
    private BigDecimal discountAmount;

    /**
     * 实际支付金额
     */
    private BigDecimal payAmount;

    /**
     * 运费
     */
    private BigDecimal freightAmount;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 支付超时时间
     */
    private LocalDateTime payOvertime;

    /**
     * 发货时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 收货时间
     */
    private LocalDateTime receiveTime;

    /**
     * 订单完成时间
     */
    private LocalDateTime finishTime;

    /**
     * 用户收货地址id
     */
    private Long addressId;

    /**
     * 省编号
     */
    private Integer provinceCode;

    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 市编号
     */
    private Integer cityCode;

    /**
     * 市编号
     */
    private String cityName;

    /**
     * 区县编码
     */
    private Integer countyCode;

    /**
     * 区县名称
     */
    private String countyName;

    /**
     * 位置
     */
    private String mapPosition;

    /**
     * 地址
     */
    private String address;

    /**
     * 0:未开票 1:开票中 2:开票完成 3:超时开票 4:不能开票
     */
    private Integer invoice;

    /**
     * 发票修改次数
     */
    private Integer invoiceChange;

    /**
     * 0:未评价 1:已评价
     */
    private Integer evaluation;

    /**
     * 0:未分佣 1:已分佣
     */
    private Integer commission;

    /**
     * 七天维权冻结期
     */
    private Integer freezeDate;

    /**
     * 0:未过维权期 1:已过维权期
     */
    private Integer rightsProtection;

    /**
     * 10:自购 20:分享购
     */
    private Integer orderType;

    /**
     * 买家备注
     */
    private String note;

    private String discountDetails;

    private BigDecimal couponAmount;

    private BigDecimal activityAmount;

    private BigDecimal pointAmount;

    /**
     * 花费积分(哈币)
     */
    private Integer pointExpend;

    /**
     * 用户取消原因
     */
    private String cancelNote;

    /**
     * 取消订单时间
     */
    private LocalDateTime cancelTime;

    /**
     * 取消人
     */
    private String cancelBy;

    /**
     * 软删除 0:未删除 1:用户删除
     */
    private Integer isDeleted;

    /**
     *  操作用户
     */
    private String operBy;

    /**
     * 操作时间
     */
    private LocalDateTime operTime;


}
