package com.scaffolding.controller.order.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/04/13/15:54
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPackageReq implements Serializable {

    private static final long serialVersionUID = 5929355314160500086L;

    /**
     * 发货人  经销商发货/品牌
     */
    @NotBlank(message = "发货人不能为空")
    private String shopId;
    /**
     * 订单号  @NotEmpty 用在集合类上面  @NotBlank 用在String上面  @NotNull 用在基本类型上
     */
    @NotBlank(message = "订单号不能为空")
    private String orderNo;
    /**
     * 物流单号
     */
    private String logisticsNo;
    /**
     * 快递公司代码
     */
    private String expressCode;
    /**
     * 快递公司名称
     */
    private String expressName;
    /**
     * 当前包裹是否需要快递
     */
    @NotNull
    private boolean needExpress;

    /**
     * 包裹产品信息
     */
    @Valid
    @NotEmpty(message = "包裹不能为空")
    private List<GoodsInfo> goodsList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GoodsInfo {

        @NotBlank(message = "发货产品Sku不能为空")
        private String skuCode;
        @NotNull(message = "发货数量不能为空")
        private Integer deliveryNum;

    }
}
