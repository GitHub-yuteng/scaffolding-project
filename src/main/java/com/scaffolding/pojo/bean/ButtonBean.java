package com.scaffolding.pojo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/04/18/15:29
 * @Description:
 */
@Data
public class ButtonBean implements Serializable {

    private static final long serialVersionUID = -4167050016008894785L;

    /**
     * 按钮类型
     */
    public Integer buttonType;
    /**
     * 按钮类型名称
     */
    public String buttonName;
    /**
     * 动作
     */
    public Integer action;

    public ButtonBean() {
    }

    public ButtonBean(Integer buttonType, String buttonName, Integer action) {
        this.buttonType = buttonType;
        this.buttonName = buttonName;
        this.action = action;
    }
}
