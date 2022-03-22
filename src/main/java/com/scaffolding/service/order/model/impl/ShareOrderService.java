package com.scaffolding.service.order.model.impl;

import com.whhim.hxh.auth.Authentication;
import com.whhim.hxh.auth.UserInfo;
import com.whhim.hxh.controller.order.req.OrderDetailReq;
import com.whhim.hxh.controller.order.req.OrderListReq;
import com.whhim.hxh.controller.order.vo.detail.OrderDetailVO;
import com.whhim.hxh.controller.order.vo.OrderItemVO;
import com.whhim.hxh.controller.order.vo.OrderTargetVO;
import com.whhim.hxh.mapper.order.ShareOrderMapper;
import com.whhim.hxh.service.order.constant.OrderTargetConstant;
import com.whhim.hxh.service.order.dto.OrderNoDTO;
import com.whhim.hxh.service.order.dto.OrderParamDTO;
import com.whhim.hxh.service.order.model.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 分享推广订单
 * @Author whh-yt
 * @Date 2022/2/25 10:57 上午
 */
@Service
public class ShareOrderService extends OrderService {

    @Autowired
    private ShareOrderMapper shareOrderMapper;

    @Override
    public List<OrderTargetVO> queryOrderTarget() {
        List<OrderTargetVO> targetList = new ArrayList<>();
        targetList.add(OrderTargetConstant.ALL_STATUS);
        targetList.add(OrderTargetConstant.WAIT_SETTLEMENT);
        targetList.add(OrderTargetConstant.SETTLED);
        targetList.add(OrderTargetConstant.INVALID);
        return targetList.stream().sorted(Comparator.comparing(OrderTargetVO::getSort)).collect(Collectors.toList());
    }

    @Override
    public List<OrderItemVO> listOrderInfo(OrderListReq orderListReq) {
        UserInfo userInfo = Authentication.getUserInfo();
        Integer curRow = (orderListReq.getCurrentPage() - 1) * orderListReq.getPageSize();
        Integer pageSize = orderListReq.getPageSize();
        List<OrderNoDTO> orderNoList = shareOrderMapper.queryOrder(orderListReq, userInfo.getId(), curRow, pageSize);
        if (CollectionUtils.isEmpty(orderNoList)) {
            return new ArrayList<>();
        }
        List<OrderItemVO> orderItemList = new ArrayList<>();
        List<String> orderNos = orderNoList.stream().map(OrderNoDTO::getOrderNo).collect(Collectors.toList());
        OrderParamDTO orderParamDTO = super.listOrderItemByOrderNoList(orderNos);
        super.assemblyOrderList(orderItemList);
        return orderItemList;
    }


    @Override
    public Integer countListOrder(OrderListReq orderListReq) {
        UserInfo userInfo = Authentication.getUserInfo();
        return shareOrderMapper.countOrder(orderListReq, userInfo.getId());
    }
}

