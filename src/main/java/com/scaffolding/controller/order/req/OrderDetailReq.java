package com.scaffolding.controller.order.req;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/06/03/8:12
 * @Description:
 */
@Data
public class OrderDetailReq extends OrderNoReq implements Serializable {

    private static final long serialVersionUID = 9075382491347807522L;
    /**
     * 订单行项目
     */
    private List<Integer> itemNos;

}