package com.scaffolding.controller.order.vo.detail;

import com.whhim.hxh.pojo.bean.BelowBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/2 8:33 上午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderBelowVO extends BelowBean {

    public OrderBelowVO() {
    }

    public OrderBelowVO(Integer belowKey, String belowName, String belowValve, Integer action, Integer sort) {
        super(belowKey, belowName, belowValve, action, sort);
    }
}
