package com.scaffolding.controller.order.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/07/09/8:12
 * @Description:
 */
@Data
public class OrderCellReq implements Serializable {

    private static final long serialVersionUID = -315389165735490019L;

    /**
     * 1: 首页  2：我的
     */
    @NotNull
    private Integer type;
}
