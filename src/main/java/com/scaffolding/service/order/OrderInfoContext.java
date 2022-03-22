package com.scaffolding.service.order;

import com.scaffolding.auth.Authentication;
import com.scaffolding.auth.UserInfo;
import com.scaffolding.controller.order.OrderShareController;
import com.scaffolding.controller.order.req.OrderDetailReq;
import com.scaffolding.controller.order.req.OrderListReq;
import com.scaffolding.controller.order.req.confirm.OrderCommitReq;
import com.scaffolding.controller.order.req.confirm.OrderConfirmReq;
import com.scaffolding.controller.order.vo.OrderCellVO;
import com.scaffolding.controller.order.vo.OrderCommitVO;
import com.scaffolding.controller.order.vo.OrderItemVO;
import com.scaffolding.controller.order.vo.OrderTargetVO;
import com.scaffolding.controller.order.vo.confirm.ConfirmOrderVO;
import com.scaffolding.controller.order.vo.detail.OrderDetailVO;
import com.scaffolding.enums.PlatformEnum;
import com.scaffolding.enums.UserTypeEnum;
import com.scaffolding.exception.AppException;
import com.scaffolding.pojo.bean.CellBean;
import com.scaffolding.pojo.bean.EnumStatusBean;
import com.scaffolding.pojo.vo.BasePageVO;
import com.scaffolding.redis.RedisService;
import com.scaffolding.service.order.constant.OrderCellConstant;
import com.scaffolding.service.order.constant.OrderMessageConstant;
import com.scaffolding.service.order.enums.OrderTypeClazzEnum;
import com.scaffolding.service.order.model.IOrderStrategy;
import com.scaffolding.service.shopCart.ShopCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: yt
 * @Date: 2021/06/03/8:03
 * @Description:
 */
@Slf4j
@Service
public class OrderInfoContext {

    @Autowired
    private OrderTypeFactory orderTypeFactory;
    @Autowired
    private ShopCartService shopCartService;

    @Autowired
    private RedisService redisService;

    /**
     * 买方 APP我的 订单Cell
     *
     * @return
     */
    public List<OrderCellVO> listMineOrderCellList() {
        List<OrderCellVO> orderCellList = new ArrayList<>();
        orderCellList.add(OrderCellConstant.WAIT_PAY);
        orderCellList.add(OrderCellConstant.WAIT_DELIVERY);
        orderCellList.add(OrderCellConstant.WAIT_RECEIVE);
        orderCellList.add(OrderCellConstant.RECEIVED);
        orderCellList.add(OrderCellConstant.COMPLETED);
        orderCellList.add(OrderCellConstant.REFUND_AFTER);
        return orderCellList.stream().sorted(Comparator.comparing(CellBean::getSort)).collect(Collectors.toList());
    }

    /**
     * 获取订单查询标签
     *
     * @param userInfo
     * @return
     */
    public List<OrderTargetVO> queryOrderTarget(String _orderType, UserInfo userInfo) {
        userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setUsertype(UserTypeEnum.DISTRIBUTER.getType());
        Integer orderType = this.getOrderType(userInfo, _orderType);
        OrderTypeClazzEnum orderTypeClazzEnum = OrderTypeClazzEnum.getEnumByType(orderType);
        assert orderTypeClazzEnum != null;
        IOrderStrategy orderModelStrategy = orderTypeFactory.getOrderModelStrategy(orderTypeClazzEnum.getTypeName());
        return orderModelStrategy.queryOrderTarget();
    }

    /**
     * @return
     */
    public List<EnumStatusBean> listOrderCellCount() {
        return new ArrayList<>();
    }

    /**
     * 确认订单页
     *
     * @param orderConfirmReq
     * @param userInfo
     * @return
     */
    public ConfirmOrderVO confirmOrder(OrderConfirmReq orderConfirmReq, UserInfo userInfo) {
        userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setUsertype(UserTypeEnum.CONSUMER.getType());
        Integer orderType = this.getOrderType(userInfo, null);
        OrderTypeClazzEnum orderTypeClazzEnum = OrderTypeClazzEnum.getEnumByType(orderType);
        assert orderTypeClazzEnum != null;
        IOrderStrategy orderModelStrategy = orderTypeFactory.getOrderModelStrategy(orderTypeClazzEnum.getTypeName());
        return orderModelStrategy.confirmOrder(orderConfirmReq);
    }

    /**
     * 提交订单
     */
    public OrderCommitVO commitOrder(OrderCommitReq orderCommitReq, UserInfo userInfo) {
        userInfo  = new UserInfo();
        userInfo.setId(1L);
        userInfo.setOpenId("oappW5Ssg_j9zEz2xjSvZDZJDEAc");
        userInfo.setUnionId("oXeJp5hRUNk_0T4o6sOo80D3nHPg");
        userInfo.setUserCode("oXeJp5hRUNk_0T4o6sOo80D3nHPg");
        userInfo.setNickname("oXeJp5hRUNk_0T4o6sOo80D3nHPg");
        userInfo.setToken("");
        userInfo.setUsertype(UserTypeEnum.CONSUMER.getType());
        userInfo.setPlatformSource(PlatformEnum.WECHAT.getPlatformCode());
        Authentication.setUserInfoThreadLocal(userInfo);
        Integer orderType = this.getOrderType(userInfo, null);
        OrderTypeClazzEnum orderTypeClazzEnum = OrderTypeClazzEnum.getEnumByType(orderType);
        assert orderTypeClazzEnum != null;
        IOrderStrategy orderModelStrategy = orderTypeFactory.getOrderModelStrategy(orderTypeClazzEnum.getTypeName());
        return orderModelStrategy.commitOrder(orderCommitReq);
    }

    /**
     * 订单列表
     *
     * @param orderListReq
     * @param userInfo
     * @return
     */
    public BasePageVO<OrderItemVO> queryOrderList(OrderListReq orderListReq, String _orderType, UserInfo userInfo) {
        BasePageVO<OrderItemVO> result = new BasePageVO<>();
        result.setCurrentPage(orderListReq.getCurrentPage());
        result.setPageSize(orderListReq.getPageSize());
        Integer orderType = this.getOrderType(userInfo, _orderType);
        OrderTypeClazzEnum orderTypeClazzEnum = OrderTypeClazzEnum.getEnumByType(orderType);
        if (Objects.isNull(orderTypeClazzEnum)) {
            throw new AppException(OrderMessageConstant.ORDER_ERROR);
        }
        IOrderStrategy orderModelStrategy = orderTypeFactory.getOrderModelStrategy(orderTypeClazzEnum.getTypeName());
        List<OrderItemVO> orderItemList = orderModelStrategy.listOrderInfo(orderListReq);
        if (CollectionUtils.isEmpty(orderItemList)) {
            result.setData(orderItemList);
            result.setTotalCount(0);
            result.setFinished(true);
            return result;
        }
        int count = orderModelStrategy.countListOrder(orderListReq);
        result.setData(orderItemList.stream().sorted(Comparator.comparing(OrderItemVO::getCreateTime).reversed()).collect(Collectors.toList()));
        result.setTotalCount(count);
        return result;
    }

    public OrderDetailVO queryOrderDetail(OrderDetailReq orderDetailReq, UserInfo userInfo) {
        Integer orderType = this.getOrderType(userInfo, null);
        OrderTypeClazzEnum orderTypeClazzEnum = OrderTypeClazzEnum.getEnumByType(orderType);
        if (Objects.isNull(orderTypeClazzEnum)) {
            throw new AppException(OrderMessageConstant.ORDER_ERROR);
        }
        IOrderStrategy orderModelStrategy = orderTypeFactory.getOrderModelStrategy(orderTypeClazzEnum.getTypeName());
        return orderModelStrategy.queryOrderDetail(orderDetailReq);
    }

    private Integer getOrderType(UserInfo userInfo, String _orderType) {
        Integer usertype = userInfo.getUsertype();
        UserTypeEnum userTypeEnums = UserTypeEnum.getEnumByType(usertype);
        switch (userTypeEnums) {
            case CONSUMER:
                return OrderTypeClazzEnum.CONSUMER_SELF_PURCHASE.getType();
            case DISTRIBUTER:
                if (OrderShareController.ORDER_TYPE.equals(_orderType)) {
                    return OrderTypeClazzEnum.SHARE.getType();
                }
                return OrderTypeClazzEnum.DISTRIBUTOR_SELF_PURCHASE.getType();
            case UNKNOWN:
            default:
                return OrderTypeClazzEnum.OREDR_SERVICE.getType();
        }
    }

}
