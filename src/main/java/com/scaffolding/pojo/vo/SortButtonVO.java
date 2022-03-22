package com.scaffolding.pojo.vo;

import com.whhim.hxh.pojo.bean.ButtonBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/2 8:30 上午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SortButtonVO extends ButtonBean {

    private Integer sort;

    public SortButtonVO() {
    }

    public SortButtonVO(Integer buttonType, String buttonName, Integer action, Integer sort) {
        super(buttonType, buttonName, action);
        this.sort = sort;
    }
}
