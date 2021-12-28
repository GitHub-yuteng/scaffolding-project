package com.scaffolding.global.style;

/**
 * @Author: yt
 * @Date: 2021/06/24/9:43
 * @Description: 配合前端适配样式
 */
public abstract class SpecialStyle {

    /**
     * 字体大小
     */
    public Integer size;
    /**
     * 字体颜色
     */
    private String color;
    /**
     * 背景颜色
     */
    private String bgColor;
    /**
     * 渐变色 开始色->结束色
     */
    private String bgEndColor;
    /**
     * 边框颜色
     */
    private String borderColor;
    /**
     * 加粗
     */
    private Boolean ifBold;
    /**
     * 边框
     */
    private Boolean hasBorder;
    /**
     * 实心(有背景BG) true 实心
     */
    private Boolean ifSolid;
    /**
     * 下划线
     */
    private Boolean hasUnderLine;
    /**
     * 动作 复制、等
     */
    private String action;

}
