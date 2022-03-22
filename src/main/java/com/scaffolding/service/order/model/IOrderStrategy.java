package com.scaffolding.service.order.model;

import com.scaffolding.controller.order.req.OrderDetailReq;
import com.scaffolding.controller.order.req.OrderListReq;
import com.scaffolding.controller.order.req.confirm.OrderConfirmReq;
import com.scaffolding.controller.order.vo.OrderItemVO;
import com.scaffolding.controller.order.vo.OrderTargetVO;
import com.scaffolding.controller.order.vo.confirm.ConfirmOrderVO;
import com.scaffolding.controller.order.vo.detail.OrderDetailVO;
import com.whhim.hxh.controller.order.req.confirm.OrderCommitReq;
import com.whhim.hxh.controller.order.vo.OrderCommitVO;

import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/06/02/15:26
 * @Description: 订单模式功能
 */
public interface IOrderStrategy {

    /**
     * 查询订单标签
     *
     * @return
     */
    List<OrderTargetVO> queryOrderTarget();

    /**
     * 查询订单列表
     *
     * @param orderListReq
     * @return
     */
    List<OrderItemVO> listOrderInfo(OrderListReq orderListReq);

    /**
     * 订单总数
     *
     * @param orderListReq
     * @return
     */
    Integer countListOrder(OrderListReq orderListReq);

    /**
     * 查询订单详情
     *
     * @param orderDetailReq
     * @return
     */
    OrderDetailVO queryOrderDetail(OrderDetailReq orderDetailReq);

    /**
     * 确认订单
     * @param orderConfirmReq
     * @return
     */
    ConfirmOrderVO confirmOrder(OrderConfirmReq orderConfirmReq);

    /**
     * 提交订单
     * @param orderCommitReq
     * @return
     */
    OrderCommitVO commitOrder(OrderCommitReq orderCommitReq);


}
