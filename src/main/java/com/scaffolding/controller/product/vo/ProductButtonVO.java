package com.scaffolding.controller.product.vo;

import com.whhim.hxh.pojo.bean.ButtonBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/3 10:47 上午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductButtonVO extends ButtonBean {

    private String attract;
    private final Integer sort;

    public ProductButtonVO(Integer buttonType, String buttonName, Integer action, Integer sort) {
        super(buttonType, buttonName, action);
        this.sort = sort;
    }

    public ProductButtonVO(Integer buttonType, String buttonName, Integer action, String attract, Integer sort) {
        super(buttonType, buttonName, action);
        this.sort = sort;
        this.attract = attract;
    }
}
