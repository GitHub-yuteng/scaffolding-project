package com.scaffolding.controller.order.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/06/10/9:23
 * @Description:
 */
@Data
public class CancelNoteReq extends com.whhim.szh.controller.app.orderInfo.model.OrderModelReq implements Serializable {

    private static final long serialVersionUID = 5441144538763883742L;
    /**
     * 1:取消，2:售后
     */
    @NotNull(message = "请选择类型")
    private Integer type;
}
