package com.scaffolding.controller.product.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/9 6:56 下午
 */
@Data
public class ProductDetailReq  {

    /**
     * 1:正常进入 2:短链进入
     */
    private Integer inWay;
    @NotBlank(message = "商品代码为空")
    private String spuCode;
    @NotBlank(message = "商品代码为空")
    private String skuCode;
    /**
     * 短链进入带有 分享人用户id
     */
    private Long shareId;
}
