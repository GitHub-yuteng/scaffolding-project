package com.scaffolding.controller.order.vo;

import com.whhim.hxh.pojo.bean.CellBean;


/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/1 1:26 下午
 */
public class OrderCellVO extends CellBean {

    public OrderCellVO() {
    }

    public OrderCellVO(Integer type, String typeName, String iconPath, Boolean disable, Integer sort) {
        super(type, typeName, iconPath, disable, sort);
    }

    @Override
    public String toString() {
        return "OrderCellVO{" +
                "type=" + type +
                ", typeName='" + typeName + '\'' +
                ", iconPath='" + iconPath + '\'' +
                ", disable=" + disable +
                ", sort=" + sort +
                '}';
    }
}
