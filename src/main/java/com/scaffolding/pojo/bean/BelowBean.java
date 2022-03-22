package com.scaffolding.pojo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/04/29/13:49
 * @Description:
 */
@Data
public class BelowBean implements Serializable {

    private static final long serialVersionUID = -53042655554134163L;

    public Integer belowKey;
    public String belowName;
    public String belowValve;
    public Integer action;
    public Integer sort;

    public BelowBean() {
    }

    public BelowBean(Integer belowKey, String belowName, String belowValve, Integer action, Integer sort) {
        this.belowKey = belowKey;
        this.belowName = belowName;
        this.belowValve = belowValve;
        this.action = action;
        this.sort = sort;
    }
}
