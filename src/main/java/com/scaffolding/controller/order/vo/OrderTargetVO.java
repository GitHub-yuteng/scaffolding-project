package com.scaffolding.controller.order.vo;

import com.whhim.hxh.pojo.bean.TargetBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/1 1:56 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderTargetVO extends TargetBean {

    public OrderTargetVO(Integer targetType, String targetName, Boolean ifDisable, Integer sort) {
        super(targetType, targetName, ifDisable, sort);
    }
}
