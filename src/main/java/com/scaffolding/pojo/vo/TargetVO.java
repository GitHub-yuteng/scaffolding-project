package com.scaffolding.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/04/18/16:29
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TargetVO implements Serializable {

    private static final long serialVersionUID = -8199199010040215494L;

    /**
     * 标签类型
     */
    private Integer targetType;
    /**
     * 标签名称
     */
    private String targetName;
    /**
     * 是否禁用
     */
    private Boolean ifDisable;
    /**
     * 排序
     */
    private Integer sort;
}
