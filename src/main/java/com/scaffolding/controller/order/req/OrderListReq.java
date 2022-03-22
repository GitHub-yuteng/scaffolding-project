package com.scaffolding.controller.order.req;

import com.scaffolding.pojo.req.BasePageReq;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/24 3:26 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderListReq extends BasePageReq implements Serializable {

    private static final long serialVersionUID = 5868843882730899628L;
    /**
     * 搜索关键词
     */
    private String searchKey;
    /**
     * 订单状态
     */
    private Integer statusType;
}
