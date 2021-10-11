package com.scaffolding.controller.order.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/06/03/8:41
 * @Description:
 */
@Data
public class OrderNoReq extends com.whhim.szh.controller.app.orderInfo.model.OrderModelReq implements Serializable {

    private static final long serialVersionUID = 9148127934778971348L;
    /**
     * 订单编号
     */
    @NotNull(message = "订单编号不能为空")
    private String orderNo;
}
