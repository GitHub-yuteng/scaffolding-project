package com.scaffolding.controller.order.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/04/15/16:05
 * @Description:
 */
@Data
public class LogisticsNoReq extends OrderNoReq implements Serializable {

    private static final long serialVersionUID = 6530458702391272667L;

    /**
     * 物流单号
     */
    @NotEmpty(message = "物流单号不能为空")
    private List<String> logisticsNoList;
}
