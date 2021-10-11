package com.scaffolding.controller.order.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/04/14/15:58
 * @Description:
 */
@Data
public class DeliveryGoodsReq implements Serializable {

    private static final long serialVersionUID = 4638146909800564032L;

    /**
     * NotBlank 作用字符串
     */
    @NotBlank(message = "订单号不能为空")
    private String orderNo;
    /**
     * NotEmpty 作用集合
     */
    @NotEmpty(message = "订单行项目不能为空")
    private List<Integer> itemNos;
}
