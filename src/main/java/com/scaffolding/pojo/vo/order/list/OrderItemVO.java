package com.scaffolding.pojo.vo.order.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/04/18/14:38
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemVO implements Serializable {

    private static final long serialVersionUID = -1908296261658727345L;

    /**
     * 店铺/经销商/快销网
     */
    private ShopInfoVO shopInfo;
    /**
     * 订单右上角状态
     */
    private CornerStatusVO cornerStatus;
    /**
     * 订单提交时间
     */
    private String commitTime;
    /**
     * 产品
     */
    private List<GoodsItemVO> goodsItems;
    /**
     * 订单标签  未支付/商家下单
     */
    private List<OrderLableVO> orderLables;
    /**
     * 类别总数
     */
    private Integer goodsTypeCount;
    /**
     * 商品总计数量
     */
    private Integer orderGoodsCount;
    /**
     * 订单总金额
     */
    private String totalAmountStr;
    /**
     * 实付金额 (终端实付金额 || 其他实付金额)
     */
    private String realAmountStr;
    /**
     * 订单提示
     */
    private OrderRemindVO remind;
    /**
     * 订单按钮
     */
    private List<OrderButtonVO> orderButtons;
    /**
     * 更多订单按钮
     */
    private List<OrderButtonVO> moreButtons;
    /**
     * 订单物流单号
     */
    private List<LogisticsInfoVO> logistics;

}
