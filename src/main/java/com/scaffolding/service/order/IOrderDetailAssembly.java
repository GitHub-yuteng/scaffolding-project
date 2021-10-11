package com.scaffolding.service.order;


import com.scaffolding.pojo.vo.order.detail.OrderDetailVO;

/**
 * @Author: yt
 * @Date: 2021/06/18/14:58
 * @Description: 将需要组装的方法抽象
 */
public interface IOrderDetailAssembly {

    /**
     * 处理订单详情状态
     * @param orderDetailVO
     * @param userInfo
     * @param model
     */
    void assemblyDetailLabel(OrderDetailVO orderDetailVO, UserInfoDto userInfo, Integer model);

    /**
     * 组装收货人信息
     * @param orderDetailVO
     * @param userInfo
     * @param model
     */
    void assemblyReceiver(OrderDetailVO orderDetailVO, UserInfoDto userInfo, Integer model);

    /**
     * 组装订单商品对应标签
     *
     * @param orderItemVOList
     */
    void assemblyOrderDetailGoodsLables(OrderItemVO orderItemVO, UserInfoDto userInfo);

    /**
     * 处理订单详情金额信息
     * @param orderDetailVO
     * @param userInfo
     * @param model
     */
    void assemblyMoneyList(OrderDetailVO orderDetailVO, UserInfoDto userInfo, Integer model);

    /**
     * 订单底部信息
     * @param orderDetailVO
     * @param userInfo
     * @param model
     */
    void assemblyBelowList(OrderDetailVO orderDetailVO, UserInfoDto userInfo, Integer model);


    /**
     * 组装订单信息售后按钮
     *
     * @param orderItemVO
     * @param userInfo
     */
    void assemblyAfterSaleBtnList(OrderItemVO orderItemVO, UserInfoDto userInfo);

    /**
     * 组装商品信息售后按钮
     *
     * @param orderItemVO
     * @param userInfo
     */
    void assemblyGoodsAfterSaleBtnList(OrderItemVO orderItemVO, UserInfoDto userInfo);
}
