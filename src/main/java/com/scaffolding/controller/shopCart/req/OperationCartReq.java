package com.scaffolding.controller.shopCart.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/8 4:48 下午
 */
@Data
public class OperationCartReq implements Serializable {

    /**
     * 操作类型
     */
    private Integer operation;
}
