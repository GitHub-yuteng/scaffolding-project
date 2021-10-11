package com.scaffolding.controller.order.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/06/09/18:13
 * @Description:
 */
@Data
public class CancelOrderReq extends OrderNoReq implements Serializable {

    private static final long serialVersionUID = -6504083792302098328L;

    /**
     * 取消说明
     */
    @NotNull(message = "请选择类型")
    private Integer cancelNoteType;

    /**
     * 0:否,1:是
     */
    private Integer addCar;
}
