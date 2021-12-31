package com.scaffolding.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/07/07/10:57
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CellVO implements Serializable {

    private static final long serialVersionUID = -4920691674650039117L;

    private Integer type;
    private String typeName;
    private String iconPath;
    private Boolean disable;
    private Integer sort;
}
