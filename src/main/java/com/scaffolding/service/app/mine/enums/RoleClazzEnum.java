package com.scaffolding.service.app.mine.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: yt
 * @Date: 2021/06/03/8:20
 * @Description: 订单模式策略实现枚举，请不要随意改动type值
 */
@Getter
@AllArgsConstructor
public enum RoleClazzEnum {

    /**
     * 角色 Mine
     */
    MINE_TM                 ("MINE_TM",      "TmMineService"),
    MINE_DEALER             ("MINE_DEALER",  "DealerMineService"),
    MINE_EMP                ("MINE_EMP",     "EmpMineService"),
    MINE_WHHEMP             ("MINE_WHHEMP",  "EmpMineService"),
    MINE_CONSUMER           ("MINE_CONSUMER","TmMineService");

    /**
     * 类型
     */
    private final String type;
    /**
     * 类型名称
     */
    private final String typeName;

    public static RoleClazzEnum getEnumByType(String type) {
        for (RoleClazzEnum orderModelClazzEnum : RoleClazzEnum.values()) {
            if (orderModelClazzEnum.getType().equals(type)) {
                return orderModelClazzEnum;
            }
        }
        return null;
    }
}
