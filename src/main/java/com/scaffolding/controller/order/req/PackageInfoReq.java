package com.scaffolding.controller.order.req;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/04/15/19:26
 * @Description:
 */
@Data
public class PackageInfoReq extends com.whhim.szh.controller.app.orderInfo.model.OrderModelReq implements Serializable {

    private static final long serialVersionUID = -4618922258625937195L;
    /**
     * 包裹信息
     */
    @Valid
    @NotEmpty(message = "包裹为空, 不允许发货")
    private List<com.whhim.szh.controller.app.orderInfo.model.DeliveryPackageReq> packageList;
}
