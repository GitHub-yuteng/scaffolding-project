package com.scaffolding.controller.order.vo.detail;

import com.whhim.hxh.controller.order.vo.OrderItemVO;
import com.whhim.hxh.pojo.vo.ReceiverVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/24 3:25 下午
 */
@Data
public class OrderDetailVO implements Serializable {

    /**
     * 订单状态label
     */
    private OrderDetailLabelVO orderDetailLabel;
    private Long addressId;
    /**
     * 收件人信息
     */
    private ReceiverVO receiver;
    /**
     * 订单信息
     */
    private OrderItemVO orderItem;
    /**
     * 订单详情金额信息
     */
    private List<OrderMoneyVO> moneyList;
    /**
     * 订单详情下方信息
     */
    private List<OrderBelowVO> belowList;
}
