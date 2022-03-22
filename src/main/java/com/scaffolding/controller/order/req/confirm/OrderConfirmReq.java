package com.scaffolding.controller.order.req.confirm;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/7 4:06 下午
 */
@Data
public class OrderConfirmReq implements Serializable {

    /**
     * 确认方式 1:直接下单 2:购物车下单
     */
    @NotNull(message = "下单异常")
    private Integer confirmWay;
    /**
     * 商品下单
     */
    @Valid
    private ProductConfirmReq productConfirm;

    private CartConfirmReq cartConfirmReq;
}
