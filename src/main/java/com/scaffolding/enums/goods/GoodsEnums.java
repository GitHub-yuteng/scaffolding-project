package com.scaffolding.enums.goods;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: yt
 * @Date: 2021/08/02/9:00
 * @Description: 商品相关枚举
 */
public interface GoodsEnums {

    @Getter
    @AllArgsConstructor
    enum GoodsStatusEnum {

        /**
         * 商品状态
         */
        WAIT_PAY        (1, "待支付"),
        WAIT_SEND       (2, "待发货"),
        WAIT_ACCEPT     (3, "待收货"),
        SUCCESSFUL_DEAL (4, "交易成功"),
        CLOSE_DEAL      (5, "交易关闭"),
        UNKNOWN         (-99, "未知"),
        ;

        private final Integer type;
        private final String typeName;

        public static GoodsStatusEnum getEnumByTypeName(String typeName) {
            for (GoodsStatusEnum goodsStatusEnum : GoodsStatusEnum.values()) {
                if (goodsStatusEnum.getTypeName().equals(typeName)) {
                    return goodsStatusEnum;
                }
            }
            return UNKNOWN;
        }

        public static GoodsStatusEnum getEnumByType(Integer type) {
            for (GoodsStatusEnum goodsStatusEnum : GoodsStatusEnum.values()) {
                if (goodsStatusEnum.getType().equals(type)) {
                    return goodsStatusEnum;
                }
            }
            return UNKNOWN;
        }
    }

    @Getter
    @AllArgsConstructor
    enum GoodsButtonEnum {

        /**
         * 商品按钮
         */
        APPLY_FOR_AFTER_SALES   (151, "申请售后", 1),
        APPLY_KEY_REFUND        (152, "申请退款", 1),
        REFUNDING               (155, "退款中", 1),
        REFUND_SUCCESS          (156, "退款成功", 1);

        private final Integer type;
        private final String typeName;
        private final Integer sort;

        public static GoodsButtonEnum getEnumByType(Integer type) {
            for (GoodsButtonEnum goodsButtonEnum : GoodsButtonEnum.values()) {
                if (goodsButtonEnum.getType().equals(type)) {
                    return goodsButtonEnum;
                }
            }
            return null;
        }

        public static GoodsButtonEnum getEnumByTypeName(String typeName) {
            for (GoodsButtonEnum goodsButtonEnum : GoodsButtonEnum.values()) {
                if (goodsButtonEnum.getTypeName().equals(typeName)) {
                    return goodsButtonEnum;
                }
            }
            return null;
        }
    }

    @Getter
    @AllArgsConstructor
    enum GoodsLabelEnum {

        /**
         * 商品标签
         */
        BEEN_DELIVERY   (1, "已发货"),
        RETURNING       (2, "退款中"),
        RETURNED        (3, "已退货"),
        BEEN_REFUND     (5, "退款成功");

        /**
         * 类型
         */
        private final Integer type;
        /**
         * 类型名称
         */
        private final String typeName;

        public static GoodsLabelEnum getEnumByTypeName(String typeName) {
            for (GoodsLabelEnum goodsLabelEnum : GoodsLabelEnum.values()) {
                if (goodsLabelEnum.getTypeName().equals(typeName)) {
                    return goodsLabelEnum;
                }
            }
            return null;
        }

        public static GoodsLabelEnum getEnumByType(Integer type) {
            for (GoodsLabelEnum goodsLabelEnum : GoodsLabelEnum.values()) {
                if (goodsLabelEnum.getType().equals(type)) {
                    return goodsLabelEnum;
                }
            }
            return null;
        }
    }

    @Getter
    @AllArgsConstructor
    enum GoodsTypeEnum {

        /**
         * 商品类型
         */
        GOODS_ORDINARY      (0, "普通商品"),
        GOODS_SHOP_GIFT     (1, "经销商赠品"),
        GOODS_DIRECT_GIFT   (2, "直营店赠品");

        /**
         * 类型
         */
        private final Integer type;
        /**
         * 类型名称
         */
        private final String typeName;

        public static GoodsTypeEnum getEnumByTypeName(String typeName) {
            for (GoodsTypeEnum goodsTypeEnum : GoodsTypeEnum.values()) {
                if (goodsTypeEnum.getTypeName().equals(typeName)) {
                    return goodsTypeEnum;
                }
            }
            return null;
        }

        public static GoodsTypeEnum getEnumByType(Integer type) {
            for (GoodsTypeEnum goodsTypeEnum : GoodsTypeEnum.values()) {
                if (goodsTypeEnum.getType().equals(type)) {
                    return goodsTypeEnum;
                }
            }
            return null;
        }
    }
}
