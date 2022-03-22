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
 * 支付流水表
 * </p>
 *
 * @author Vm
 * @since 2022-03-15 19:05:14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("hxh_payment_bill")
public class HxhPaymentBillEntity {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String paymentNo;

    private String orderNo;

    /**
     * 0:支付中 1:支付成功 2:支付失败 3:作废
     */
    private Integer payStatus;

    private String submitBy;

    private String payPattern;

    private BigDecimal payAmount;

    private LocalDateTime submitTime;

    private LocalDateTime callbackTime;

    private String thirdChannelNo;

    private BigDecimal fee;


}
