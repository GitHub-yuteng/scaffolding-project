package com.scaffolding.controller.order.req.confirm;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/9 3:48 下午
 */
@Data
public class ProductConfirmReq {

    @NotBlank(message = "商品信息为空")
    private String skuCode;
    private Integer buyNum;

    private Long storeId;
    private Long shareId;
}
