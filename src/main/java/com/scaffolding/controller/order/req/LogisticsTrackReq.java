package com.scaffolding.controller.order.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * @author 14569
 */
@Data
public class LogisticsTrackReq implements Serializable {

    private static final long serialVersionUID = -249655449165697179L;

    /**
     * 订单编号
     */
    @NotNull(message = "订单编号不能为空")
    private String orderNo;

    @NotBlank(message = "快递单号不能为空")
    private String expressNo;

    @NotBlank(message = "快递公司编码不能为空")
    private String expressCode;

    private String expressName;

}
