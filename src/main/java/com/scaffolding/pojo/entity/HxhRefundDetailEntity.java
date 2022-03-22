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
 * @since 2022-03-07 09:03:23
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("hxh_refund_detail")
public class HxhRefundDetailEntity {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String refundNo;

    private String orderNo;

    private Integer itemNo;

    private String spuCode;

    private String skuCode;

    private String materialCode;

    /**
     * 售后状态 -1:申请关闭 1:申请售后 2:审核通过 3:审核不通过 4:待寄回 5:已寄回 6:待退款(发起退) 7:退款完成 8:拒绝退款 9:换货完成
     */
    private Integer refundStatus;

    /**
     * 售后数量
     */
    private Integer applyNum;

    /**
     * 分摊金额
     */
    private BigDecimal refundApportion;


}
