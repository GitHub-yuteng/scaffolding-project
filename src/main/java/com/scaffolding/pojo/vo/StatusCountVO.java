package com.scaffolding.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2021/12/27 4:34 下午
 */
@Data
public class StatusCountVO implements Serializable {

    private Integer type;
    private String count;
}
