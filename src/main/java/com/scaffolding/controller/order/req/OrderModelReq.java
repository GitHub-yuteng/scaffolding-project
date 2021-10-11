package com.scaffolding.controller.order.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/06/02/20:48
 * @Description:
 */
@Data
public class OrderModelReq implements Serializable {

    private static final long serialVersionUID = 110844876326456901L;

    /**
     * 订单模式
     * 11：终端订单 12：经销商订单 13：业务员订单 14：批发商 21：直营接单
     * 22: 终端直营店 23：经销商(经销商购买品牌商) 24：品牌商直营店(品牌商购买品牌商)  25：C端消费者 27：直播订单
     */
    private Integer orderModel;
}
