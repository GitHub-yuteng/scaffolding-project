package com.scaffolding.controller.order.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/06/03/8:43
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderTargetReq extends OrderModelReq implements Serializable {


    private static final long serialVersionUID = 2487368278869273603L;
    /**
     * 标签返回  1：状态 2：多筛选条件
     */
    private Integer flag;
}
