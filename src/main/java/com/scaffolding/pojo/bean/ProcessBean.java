package com.scaffolding.pojo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/4 1:47 下午
 */
@Data
public class ProcessBean implements Serializable {

    private Integer processType;
    private String process;
    private String date;
    private Integer sort;
}
