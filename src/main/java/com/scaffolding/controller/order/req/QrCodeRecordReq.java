package com.scaffolding.controller.order.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 14569
 * @Auther: YT
 * @Date: 2021/03/15/13:39
 * @Description:
 */
@Data
public class QrCodeRecordReq implements Serializable {

    private static final long serialVersionUID = -7603372320212514691L;

    /**
     * 订单号
     */
    @NotNull(message = "订单号不能为空")
    private String orderNo;

    /**
     * 终端代码
     */
    private String tmNo;

    /**
     * App type
     */
    @NotNull(message = "type 不能为空")
    private String type;

}
