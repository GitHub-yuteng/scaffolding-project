package com.scaffolding.pojo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/07/07/10:57
 * @Description:
 */
@Data
public class CellBean implements Serializable {

    private static final long serialVersionUID = -4920691674650039117L;

    public Integer type;
    public String typeName;
    public String iconPath;
    public Boolean disable;
    public Integer sort;

    public CellBean() {
    }

    public CellBean(Integer type, String typeName, String iconPath, Boolean disable, Integer sort) {
        this.type = type;
        this.typeName = typeName;
        this.iconPath = iconPath;
        this.disable = disable;
        this.sort = sort;
    }
}
