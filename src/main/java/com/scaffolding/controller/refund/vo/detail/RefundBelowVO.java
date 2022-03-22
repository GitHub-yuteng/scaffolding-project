package com.scaffolding.controller.refund.vo.detail;

import com.whhim.hxh.pojo.bean.BelowBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/4 1:20 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RefundBelowVO extends BelowBean {

    public RefundBelowVO() {
    }

    public RefundBelowVO(Integer belowKey, String belowName, String belowValve, Integer action, Integer sort) {
        super(belowKey, belowName, belowValve, action, sort);
    }
}
