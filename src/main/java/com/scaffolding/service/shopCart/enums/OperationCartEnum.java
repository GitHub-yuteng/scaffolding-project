package com.scaffolding.service.shopCart.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/8 4:49 下午
 */
@Getter
@AllArgsConstructor
public enum OperationCartEnum {

    CLEAR      (-1,"清空无效商品"),
    DELETE_ALL (0,"全部删除"),
    ADD        (1,"添加"),
    /**
     * 对单一商品进行修改购物车商品数量，更改规格等
     */
    UPDATE     (2,"更新"),
    DELETE     (3,"删除"),

    ;

    private final Integer type;
    private final String typeName;

}
