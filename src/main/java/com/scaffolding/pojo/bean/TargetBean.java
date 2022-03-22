package com.scaffolding.pojo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/04/18/16:29
 * @Description:
 */
@Data
public class TargetBean implements Serializable {

    private static final long serialVersionUID = -8199199010040215494L;

    /**
     * 标签类型
     */
    public Integer targetType;
    /**
     * 标签名称
     */
    public String targetName;
    /**
     * 是否禁用
     */
    public Boolean ifDisable;
    /**
     * 排序
     */
    public Integer sort;

    public TargetBean() {
    }

    public TargetBean(Integer targetType, String targetName, Boolean ifDisable, Integer sort) {
        this.targetType = targetType;
        this.targetName = targetName;
        this.ifDisable = ifDisable;
        this.sort = sort;
    }
}
