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
 * 
 * </p>
 *
 * @author Vm
 * @since 2022-03-07 09:03:12
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("hxh_refund")
public class HxhRefundEntity {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 售后编号
     */
    private String refundNo;

    /**
     * 售后状态 -1:申请关闭 1:申请售后 2:审核通过 3:审核不通过 4:待寄回 5:已寄回 6:待退款(发起退) 7:退款完成 8:拒绝退款 9:换货完成
     */
    private Integer refundStatus;

    private String orderNo;

    /**
     * 1:仅退款 2:退货 3:退货退款 
     */
    private Integer refundType;

    /**
     * 售后原因
     */
    private String refundReason;

    /**
     * 退款补充说明
     */
    private String supplementNote;

    /**
     * 申请人（user_code/system/shop）
     */
    private String applyBy;

    private LocalDateTime applyTime;

    /**
     * 审核人
     */
    private String checkBy;

    /**
     * 1:同意 2:不同意 3:拒绝收货(1->3)
     */
    private Integer ifAgree;

    /**
     * 商家审核原因
     */
    private String shopReason;

    /**
     * 审核时间
     */
    private LocalDateTime checkTime;

    /**
     * 退款发起时间
     */
    private LocalDateTime refundTime;

    /**
     * 退款到账时间
     */
    private LocalDateTime refundArrivalTime;

    /**
     * 申请取消时间
     */
    private LocalDateTime applyCancelTime;

    /**
     * 用户寄回商品时间
     */
    private LocalDateTime sendBackTime;

    /**
     * 商家收货时间
     */
    private LocalDateTime receiveTime;

    /**
     * 取消人
     */
    private String applyCancelBy;

    /**
     * 快递公司编码
     */
    private String expressCode;

    /**
     * 快递公司名称
     */
    private String expressName;

    private String logisticsNo;

    /**
     * JsonArray
     */
    private String refundVoucher;


}
