package com.scaffolding.service.order;

import com.whhim.szh.controller.app.orderInfo.model.OrderListReq;
import com.whhim.szh.dto.UserInfoDto;
import com.whhim.szh.service.app.orderInfo.base.OrderItemVO;
import com.whhim.szh.service.app.orderInfo.orderDetail.OrderDetailVO;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/06/18/15:25
 * @Description: 订单抽象类提供组装功能
 */
public abstract class AbstractOrderInfo implements IOrderListAssembly, IOrderDetailAssembly {

    /**
     * 模版方法，final 不让子类覆盖
     *
     * @param orderListReq
     * @param orderItemVOList
     * @param userInfo
     */
    protected final void assemblyOrderList(OrderListReq orderListReq, List<OrderItemVO> orderItemVOList, UserInfoDto userInfo) {
        makeSureOrderModel(orderListReq, orderItemVOList, userInfo);
        assemblyStoreInfo(orderItemVOList, userInfo);
        assemblyCornerStatus(orderItemVOList, userInfo);
        assemblyOrderLables(orderItemVOList, userInfo);
        assemblyLogistics(orderItemVOList, userInfo);
        assemblyBtnList(orderItemVOList, userInfo);
        assemblyOrderListGoodsLables(orderItemVOList,userInfo);
        processOrderListInfo(orderItemVOList,userInfo);
    }



    /**
     * 模版方法，final 不让子类覆盖
     *
     * @param orderDetailVO
     * @param userInfo
     * @param model
     */
    protected final void assemblyOrderDetail(OrderDetailVO orderDetailVO, UserInfoDto userInfo, Integer model) {
        assemblyDetailLabel(orderDetailVO, userInfo, model);
        assemblyReceiver(orderDetailVO, userInfo, model);
        assemblyStoreInfo(Arrays.asList(orderDetailVO.getOrderItem()), userInfo);
        assemblyCornerStatus(Arrays.asList(orderDetailVO.getOrderItem()), userInfo);
        assemblyOrderDetailGoodsLables(orderDetailVO.getOrderItem(),userInfo);
        assemblyOrderLables(Arrays.asList(orderDetailVO.getOrderItem()), userInfo);
        assemblyMoneyList(orderDetailVO, userInfo, model);
        assemblyBelowList(orderDetailVO, userInfo, model);
        assemblyLogistics(Arrays.asList(orderDetailVO.getOrderItem()), userInfo);
        assemblySingleItemBtnList(orderDetailVO.getOrderItem(), userInfo);
        assemblyAfterSaleBtnList(orderDetailVO.getOrderItem(), userInfo);
        assemblyGoodsAfterSaleBtnList(orderDetailVO.getOrderItem(),userInfo);
        finalProcessOrderDetail(orderDetailVO, userInfo);
    }

    /**
     * 最终处理订单详情信息
     * @param orderDetailVO
     * @param userInfo
     */
    protected abstract void finalProcessOrderDetail(OrderDetailVO orderDetailVO, UserInfoDto userInfo);

}
