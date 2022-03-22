package com.scaffolding.controller.refund.vo;

import com.whhim.hxh.pojo.vo.SortButtonVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/3 2:48 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RefundButtonVO extends SortButtonVO {

    public RefundButtonVO() {
    }

    public RefundButtonVO(Integer buttonType, String buttonName, Integer action, Integer sort) {
        super(buttonType, buttonName, action, sort);
    }
}
