package com.scaffolding.service.order.model.template;

import com.whhim.hxh.controller.order.vo.confirm.ConfirmOrderVO;
import com.whhim.hxh.controller.order.vo.detail.OrderDetailVO;
import com.whhim.hxh.controller.order.vo.OrderItemVO;
import com.whhim.hxh.service.order.dto.OrderParamDTO;

import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/06/18/14:58
 * @Description: 提供组装订单列表信息功能
 */
public interface IOrderAssembly {

    /**
     * 组装店铺信息
     *
     * @param orderItemVO
     * @param orderParamDTO
     */
    void assemblyOrderStore(OrderItemVO orderItemVO, OrderParamDTO orderParamDTO);

    /**
     * 组装店铺信息
     */
    default void assemblyOrderListStore(List<OrderItemVO> orderItemVOList) {
        orderItemVOList.forEach(item -> this.assemblyOrderStore(item, item.getOrderParamDTO()));
    }

    void assemblyOrderDetailLabel(OrderDetailVO orderDetailVO);

    /**
     * 组装收货人信息
     * @param orderDetailVO
     */
    void assemblyOrderReceiver(OrderDetailVO orderDetailVO);

    /**
     * 组装确认订单页金额
     * @param confirmOrderVO
     */
    void assemblyConfirmOrderMoney(ConfirmOrderVO confirmOrderVO);

    /**
     * 组装订单详情金额
     * @param orderDetailVO
     */
    void assemblyOrderDetailMoney(OrderDetailVO orderDetailVO);

    /**
     * 组装订单详情金额
     * @param orderDetailVO
     */
    void assemblyOrderDetailBelowList(OrderDetailVO orderDetailVO);

    /**
     * 组装订单信息按钮
     */
    void assemblyOrderBtn(OrderItemVO orderItemVO);

    /**
     * 组装列表信息按钮
     *
     * @param orderItemVOList
     */
    default void assemblyOrderListBtn(List<OrderItemVO> orderItemVOList) {
        orderItemVOList.forEach(this::assemblyOrderBtn);
    }


}
