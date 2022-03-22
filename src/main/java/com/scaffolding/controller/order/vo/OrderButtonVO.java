package com.scaffolding.controller.order.vo;

import com.whhim.hxh.pojo.vo.SortButtonVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/2 8:30 上午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderButtonVO extends SortButtonVO {

    public OrderButtonVO() {
    }

    public OrderButtonVO(Integer buttonType, String buttonName, Integer action, Integer sort) {
        super(buttonType, buttonName, action, sort);
    }
}
