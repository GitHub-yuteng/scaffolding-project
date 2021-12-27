package com.scaffolding.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/04/18/15:29
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ButtonVO implements Serializable {

    private static final long serialVersionUID = -4167050016008894785L;

    /**
     * 按钮类型
     */
    private Integer buttonType;
    /**
     * 按钮类型名称
     */
    private String buttonName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 预留字段
     */
    private String prepare;
    /**
     * 图标
     */
    private String iconUrl;
}
