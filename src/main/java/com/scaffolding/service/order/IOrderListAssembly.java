package com.scaffolding.service.order;

import com.whhim.szh.controller.app.orderInfo.model.OrderListReq;
import com.whhim.szh.dto.UserInfoDto;
import com.whhim.szh.service.app.orderInfo.base.OrderItemVO;

import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/06/18/14:58
 * @Description: 提供组装订单部分信息功能
 */
public interface IOrderListAssembly {

    /**
     * 返回之前对终端角色做订单模式判定
     *
     * @param orderListReq
     * @param orderItemVOList
     * @param userInfo
     */
    void makeSureOrderModel(OrderListReq orderListReq, List<OrderItemVO> orderItemVOList, UserInfoDto userInfo);

    /**
     * 组装店铺信息
     *
     * @param orderItemVOList
     * @param userInfo
     */
    void assemblyStoreInfo(List<OrderItemVO> orderItemVOList, UserInfoDto userInfo);

    /**
     * 组装订单信息右上角状态
     *  @param orderItemVOList
     * @param userInfo
     */
    void assemblyCornerStatus(List<OrderItemVO> orderItemVOList, UserInfoDto userInfo);

    /**
     * 根据角色 订单模式 批量组装订单信息
     *
     * @param orderItemVOList
     * @param userInfo
     */
    default void assemblyBtnList(List<OrderItemVO> orderItemVOList, UserInfoDto userInfo) {
        orderItemVOList.forEach(item -> {
            this.assemblySingleItemBtnList(item, userInfo);
        });
    }

    /**
     * 组装物流信息
     *
     * @param orderItemVOList
     * @param userInfo
     */
    void assemblyLogistics(List<OrderItemVO> orderItemVOList, UserInfoDto userInfo);

    /**
     * 组装订单信息按钮
     *
     * @param orderItemVO
     * @param userInfo
     */
    void assemblySingleItemBtnList(OrderItemVO orderItemVO, UserInfoDto userInfo);

    /**
     * 组装订单标签
     *
     * @param orderItemVOList
     */
    void assemblyOrderLables(List<OrderItemVO> orderItemVOList,UserInfoDto userInfo);

    /**
     * 组装订单商品对应标签
     *
     * @param orderItemVOList
     */
    void assemblyOrderListGoodsLables(List<OrderItemVO> orderItemVOList,UserInfoDto userInfo);

    /**
     * 处理订单列表数据
     * @param orderItemVOList
     * @param userInfo
     */
    void processOrderListInfo(List<OrderItemVO> orderItemVOList,UserInfoDto userInfo);
}
