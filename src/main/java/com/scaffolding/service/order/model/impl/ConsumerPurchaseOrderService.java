package com.scaffolding.service.order.model.impl;

import com.whhim.hxh.auth.Authentication;
import com.whhim.hxh.auth.UserInfo;
import com.whhim.hxh.controller.order.req.OrderDetailReq;
import com.whhim.hxh.controller.order.req.OrderListReq;
import com.whhim.hxh.controller.order.req.confirm.OrderCommitReq;
import com.whhim.hxh.controller.order.req.confirm.OrderConfirmReq;
import com.whhim.hxh.controller.order.vo.OrderCommitVO;
import com.whhim.hxh.controller.order.vo.OrderItemVO;
import com.whhim.hxh.controller.order.vo.confirm.ConfirmOrderVO;
import com.whhim.hxh.controller.order.vo.confirm.StoreProductVO;
import com.whhim.hxh.controller.order.vo.detail.OrderDetailVO;
import com.whhim.hxh.controller.order.vo.detail.OrderMoneyVO;
import com.whhim.hxh.controller.product.vo.ProductVO;
import com.whhim.hxh.exception.AppException;
import com.whhim.hxh.mapper.HxhOrderLogisticsMapper;
import com.whhim.hxh.mapper.order.ConsumerPurchaseOrderMapper;
import com.whhim.hxh.pojo.entity.HxhMaterialEntity;
import com.whhim.hxh.pojo.entity.HxhOrderDetailEntity;
import com.whhim.hxh.pojo.entity.HxhOrderEntity;
import com.whhim.hxh.service.order.constant.OrderMessageConstant;
import com.whhim.hxh.service.order.dto.OrderNoDTO;
import com.whhim.hxh.service.order.dto.OrderParamDTO;
import com.whhim.hxh.service.order.enums.ConfirmWayEnum;
import com.whhim.hxh.service.order.enums.OrderMoneyEnum;
import com.whhim.hxh.service.order.enums.OrderTypeClazzEnum;
import com.whhim.hxh.service.order.model.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 分销员自购订单
 * @Author whh-yt
 * @Date 2022/2/25 10:56 上午
 */
@Service
public class ConsumerPurchaseOrderService extends OrderService {

    @Autowired
    private ConsumerPurchaseOrderMapper consumerPurchaseOrderMapper;
    @Autowired
    private HxhOrderLogisticsMapper hxhOrderLogisticsMapper;

    @Override
    public List<OrderItemVO> listOrderInfo(OrderListReq orderListReq) {
        List<OrderItemVO> orderItemList = super.listOrderInfo(orderListReq);
        UserInfo userInfo = Authentication.getUserInfo();
        Integer curRow = (orderListReq.getCurrentPage() - 1) * orderListReq.getPageSize();
        Integer pageSize = orderListReq.getPageSize();
        List<OrderNoDTO> orderNoList = consumerPurchaseOrderMapper.queryOrder(orderListReq, userInfo.getUserCode(), curRow, pageSize);
        if (CollectionUtils.isEmpty(orderNoList)) {
            return new ArrayList<>();
        }
        List<String> orderNos = orderNoList.stream().map(OrderNoDTO::getOrderNo).collect(Collectors.toList());
        // 根据订单号 获取所有的订单信息
        OrderParamDTO orderParamDTO = super.listOrderItemByOrderNoList(orderNos);
        List<HxhOrderEntity> orderList = orderParamDTO.getOrderList();
        List<HxhOrderDetailEntity> orderDetailList = orderParamDTO.getOrderDetailList();
        List<HxhMaterialEntity> materialList = orderParamDTO.getMaterialList();
        Map<String, HxhOrderEntity> orderMap = orderList.stream().collect(Collectors.toMap(HxhOrderEntity::getOrderNo, item -> item));
        Map<String, List<HxhOrderDetailEntity>> orderDetailMap = orderDetailList.stream().collect(Collectors.groupingBy(HxhOrderDetailEntity::getOrderNo));
        Map<String, HxhMaterialEntity> skuMap = materialList.stream().collect(Collectors.toMap(HxhMaterialEntity::getSkuCode, item -> item));
        for (Map.Entry<String, HxhOrderEntity> orderEntry : orderMap.entrySet()) {
            String orderNo = orderEntry.getKey();
            // 该订单主表信息
            HxhOrderEntity orderEntity = orderEntry.getValue();
            //该订单系表信息
            List<HxhOrderDetailEntity> orderDetailEntitieList = orderDetailMap.get(orderNo);
            OrderItemVO orderItemVO = super.assemblyOrderItemVO(orderEntity, orderDetailEntitieList, materialList);
            orderItemList.add(orderItemVO);
        }
        super.assemblyOrderList(orderItemList);
        return orderItemList;
    }

    @Override
    public Integer countListOrder(OrderListReq orderListReq) {
        UserInfo userInfo = Authentication.getUserInfo();
        return consumerPurchaseOrderMapper.countOrder(orderListReq, userInfo.getUserCode());
    }

    @Override
    public OrderDetailVO queryOrderDetail(OrderDetailReq orderDetailReq) {
        OrderDetailVO orderDetail = new OrderDetailVO();
        OrderParamDTO orderParamDTO = super.getOrderItemByOrderNo(orderDetailReq.getOrderNo());
        OrderItemVO orderItemVO = super.assemblyOrderItemVO(orderParamDTO.getOrderInfo(), orderParamDTO.getOrderDetailList(), orderParamDTO.getMaterialList());
        orderDetail.setOrderItem(orderItemVO);
        super.assemblyOrderDetail(orderDetail);
        return orderDetail;
    }

    @Override
    public ConfirmOrderVO confirmOrder(OrderConfirmReq orderConfirmReq) {
        ConfirmOrderVO confirmOrderVO = super.confirmOrder(orderConfirmReq);
        List<StoreProductVO> storeProductList = confirmOrderVO.getStoreProductList();

        Integer countTotal = 0;
        // 总付款金额
        BigDecimal paymentAmount = BigDecimal.ZERO;
        for (StoreProductVO storeProductVO : storeProductList) {
            List<ProductVO> productList = storeProductVO.getProductList();
            // 共几件商品
            for (ProductVO productVO : productList) {
                countTotal += productVO.getBuyCount();
            }
            // 金额
            this.assemblyConfirmOrderMoney(confirmOrderVO);
            // 最后的金额
            for (OrderMoneyVO orderMoneyVO : confirmOrderVO.getMoneyList()) {
                BigDecimal money = orderMoneyVO.getMoney();
                paymentAmount = paymentAmount.add(money);
            }
        }
        confirmOrderVO.setCountTotal(countTotal);
        // 可以增加营销接口接入 计算 价格
        confirmOrderVO.setPaymentAmount(OrderMoneyEnum.ORDER_AMOUNT.getCurrency() + paymentAmount.setScale(2, RoundingMode.DOWN).toPlainString());
        return confirmOrderVO;
    }

    @Override
    public OrderCommitVO commitOrder(OrderCommitReq orderCommitReq) {
        OrderCommitVO orderCommitVO = super.commitOrder(orderCommitReq);
        // 生成完毕订单信息，根据来源做处理，增加销量/删除购物车信息等
        Integer confirmWay = orderCommitReq.getConfirmWay();
        ConfirmWayEnum confirmWayEnum = ConfirmWayEnum.getEnumByType(confirmWay);
        switch (confirmWayEnum) {
            case PRODUCT_CONFIRM:
                // 商详下单 做简单操作 销量等
                // 根据请求参数初始化订单信息 为插入做准备
                OrderParamDTO orderParamDTO = super.buildOrderEntity(orderCommitReq);
                HxhOrderEntity orderInfo = orderParamDTO.getOrderInfo();
                orderInfo.setOrderType(OrderTypeClazzEnum.CONSUMER_SELF_PURCHASE.getType());
                List<HxhOrderDetailEntity> orderDetailList = orderParamDTO.getOrderDetailList();
                List<String> orderNoList = super.createOrder(orderInfo, orderDetailList);
                orderCommitVO.setOrderNo(orderNoList);
                break;
            case SHOPCART_CONFIRM:
                // TODO  购物车下单 删除购物车信息等  如果多订单，则 分别创建订单信息 返回订单号
                shopCartHandler.commitOrder(orderCommitReq);
                break;
            default:
                throw new AppException(OrderMessageConstant.CREATE_ORDER_ERROR);
        }
        return orderCommitVO;
    }

    @Override
    public void assemblyConfirmOrderMoney(ConfirmOrderVO confirmOrderVO) {
        // 基本金额
        super.assemblyConfirmOrderMoney(confirmOrderVO);
        List<OrderMoneyVO> moneyList = confirmOrderVO.getMoneyList();
        // TODO 预留营销接口 计算 活动 优惠券等
        confirmOrderVO.setMoneyList(confirmOrderVO.getMoneyList().stream().sorted(Comparator.comparing(OrderMoneyVO::getSort)).collect(Collectors.toList()));
    }
}
