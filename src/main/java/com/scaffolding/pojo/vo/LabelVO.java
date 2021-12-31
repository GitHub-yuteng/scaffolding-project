package com.scaffolding.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author yt
 * @Date 2021/12/27 6:37 下午
 */
@Data
public class LabelVO implements Serializable {

    private static final long serialVersionUID = -1199284356484877965L;

    private Integer labelType;
    private String labelDesc;
}
