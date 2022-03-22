package com.scaffolding.controller.order.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.whhim.hxh.controller.store.vo.StoreVO;
import com.whhim.hxh.pojo.vo.RemindVO;
import com.whhim.hxh.service.order.dto.OrderParamDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/24 3:10 下午
 */
@Data
public class OrderItemVO implements Serializable {

    private String orderNo;
    private String createTime;
    private OrderLabelVO cornerLabel;
    private StoreVO store;
    private List<OrderProductVO> productList;
    /**
     * 种类
     */
    private Integer kindTotal;
    /**
     * 数量
     */
    private Integer countTotal;
    /**
     * 提示
     */
    private RemindVO remind;
    private String payAmount;
    private List<OrderButtonVO> buttonList;
    private Long countdownTime;
    /**
     * 佣金
     */
    private String commissions;

    @JsonIgnore
    private OrderParamDTO orderParamDTO;
}
