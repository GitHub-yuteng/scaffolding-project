package com.scaffolding.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2021/12/27 6:37 下午
 */
@Data
public class LabelVO implements Serializable {

    private Integer labelType;
    private String labelDesc;
}
