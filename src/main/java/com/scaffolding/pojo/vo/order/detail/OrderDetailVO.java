package com.scaffolding.pojo.vo.order.detail;

import com.scaffolding.pojo.vo.express.ExpressVO;
import com.scaffolding.pojo.vo.order.list.OrderItemVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/04/18/14:53
 * @Description: 订单详情VO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailVO implements Serializable {

    private static final long serialVersionUID = 6878886810968797857L;

    /**
     * 订单详情状态Icon对象
     */
    private OrderTopLabelVO orderTopLabel;
    /**
     * 物流最新信息
     */
    private ExpressVO express;
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
