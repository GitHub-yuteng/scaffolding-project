package com.scaffolding.controller.refund.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/4 10:21 上午
 */
@Data
public class RefundDetailReq {

    /**
     * 1:仅退款 2:退货 3:退货退款
     */
    private Integer refundType;
    /**
     * 0: 申请售后 >0 查看售后详情
     */
    private Integer refundStatus;

    @NotBlank
    private String orderNo;
    private List<Integer> itemNoList;
    private String skuCode;

    private String refundNo;
    private Integer applyNum;

}
