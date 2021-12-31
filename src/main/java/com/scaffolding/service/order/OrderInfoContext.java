package com.scaffolding.service.order;

import com.scaffolding.pojo.vo.CellVO;
import com.scaffolding.service.order.constant.OrderCellConstant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: yt
 * @Date: 2021/06/03/8:03
 * @Description:
 */
@Service
public class OrderInfoContext {



    /**
     * 买方 APP我的 订单Cell
     *
     * @return
     */
    public List<CellVO> listMineOrderCellList() {
        List<CellVO> orderCellList = new ArrayList<>();
        orderCellList.add(OrderCellConstant.WAIT_PAY);
        orderCellList.add(OrderCellConstant.WAIT_DELIVERY);
        orderCellList.add(OrderCellConstant.WAIT_RECEIVE);
        orderCellList.add(OrderCellConstant.WAIT_EVALUATION);
        orderCellList.add(OrderCellConstant.REFUND_AFTER_MINE);
        return orderCellList.stream().sorted(Comparator.comparing(CellVO::getSort)).collect(Collectors.toList());
    }

}
