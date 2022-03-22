package com.scaffolding.service.order.model.template;


import com.whhim.hxh.controller.order.vo.detail.OrderDetailVO;
import com.whhim.hxh.controller.order.vo.OrderItemVO;
import com.whhim.hxh.pojo.entity.HxhMaterialEntity;
import com.whhim.hxh.pojo.entity.HxhOrderDetailEntity;
import com.whhim.hxh.pojo.entity.HxhOrderEntity;
import com.whhim.hxh.service.order.model.template.IOrderAssembly;

import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/06/18/15:25
 * @Description: 订单抽象类提供组装功能
 */
public abstract class AbstractOrderTemplate implements IOrderAssembly {

    /**
     * 模版方法，final 不让子类覆盖
     *
     * @param orderItemList
     */
    protected final void assemblyOrderList(List<OrderItemVO> orderItemList) {
        this.assemblyOrderListStore(orderItemList);
        this.assemblyOrderListBtn(orderItemList);
    }

    protected final void assemblyOrderDetail(OrderDetailVO orderDetailVO) {
        this.assemblyOrderDetailLabel(orderDetailVO);
        this.assemblyOrderReceiver(orderDetailVO);
        this.assemblyOrderDetailMoney(orderDetailVO);
        this.assemblyOrderBtn(orderDetailVO.getOrderItem());
        this.assemblyOrderDetailBelowList(orderDetailVO);
    }

    /**
     * 根据订单信息组装 OrderItemVO
     *
     * @param orderEntity
     * @param orderDetailEntityList
     * @param materialList
     * @return
     */
    protected abstract OrderItemVO assemblyOrderItemVO(HxhOrderEntity orderEntity,
                                                       List<HxhOrderDetailEntity> orderDetailEntityList,
                                                       List<HxhMaterialEntity> materialList);
}
