package com.scaffolding.pojo.vo.order.list;

import com.scaffolding.global.style.SpecialStyle;
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
public class OrderButtonVO implements Serializable {

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
     * 样式
     */
    private SpecialStyle specialStyle;
    /**
     * 预留字段
     */
    private String prepare;
    /**
     * 图标
     */
    private String iconUrl;
}
