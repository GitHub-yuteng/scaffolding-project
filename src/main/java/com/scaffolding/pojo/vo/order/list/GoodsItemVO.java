package com.scaffolding.pojo.vo.order.list;

import com.scaffolding.pojo.vo.goods.BaseGoodsVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @Author: yt
 * @Date: 2021/04/21/10:03
 * @Description: 商品基础信息类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsItemVO implements Serializable {

    private static final long serialVersionUID = 8873607223944954047L;

    /**
     * 跳转商详需要传的支持参数 本地店铺SH 其余KXW
     */
    private String shopId;

    /**
     * Sku基本信息
     */
    private BaseGoodsVO baseGoodsInfo;
    /**
     * 产品订单序号
     */
    private Integer itemNo;
    /**
     * 数量
     */
    private Integer goodsCount;
    /**
     * 单价
     */
    private BigDecimal casePrice;
    private String casePriceStr;

    public String getCasePriceStr() {
        if (Objects.isNull(this.casePrice)) {
            return BigDecimal.ZERO.stripTrailingZeros().toPlainString();
        }
        return this.casePrice.setScale(2, BigDecimal.ROUND_DOWN).toPlainString();
    }

    /**
     * 标签
     */
    private List<GoodsLabelVO> goodsLabels;
    /**
     * 订单详情 商品按钮
     */
    private List<OrderButtonVO> goodsBtnList;
    /**
     * 赠品
     */
    private Integer giftType = 1;
    /**
     * 是否已发货
     */
    private Boolean ifDelivery = false;
    /**
     * 是否已退款
     */
    private Boolean ifRefund = false;
    /**
     * 售后状态
     */
    private Integer refundStatus = -1;
    /**
     * 退款金额
     */
    private BigDecimal returnBalance;
    /**
     * 数据商品状态类型
     */
    private Integer goodsStatusType;
    /**
     * 数据商品状态
     */
    private String goodsStatus;
    /**
     * 售后单号
     */
    private String returnOrderNo;

}
