package com.scaffolding.pojo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author yt
 * @Date 2021/12/27 6:37 下午
 */
@Data
public class LabelBean implements Serializable {

    private static final long serialVersionUID = -1199284356484877965L;

    public Integer labelType;
    public String labelName;

    public LabelBean() {
    }

    public LabelBean(Integer labelType, String labelName) {
        this.labelType = labelType;
        this.labelName = labelName;
    }
}
