package com.scaffolding.controller.order.vo.confirm;

import com.whhim.hxh.controller.order.vo.detail.ReceivedAddressVO;
import com.whhim.hxh.controller.order.vo.OrderProductVO;
import com.whhim.hxh.controller.order.vo.detail.OrderMoneyVO;
import com.whhim.hxh.controller.store.vo.StoreVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/7 3:58 下午
 */
@Data
public class ConfirmOrderVO implements Serializable {

    private ReceivedAddressVO receivedAddress;
    private List<StoreProductVO> storeProductList;
    private List<OrderMoneyVO> moneyList;
    private String payPattern;
    private Integer countTotal;
    private String paymentAmount;
}
