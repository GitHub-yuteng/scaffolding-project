package com.scaffolding.controller.order.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/28 1:43 下午
 */
@Data
public class OrderCommitVO implements Serializable {

    /**
     * 返回的订单号
     */
    private List<String> orderNo;
}
