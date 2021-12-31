package com.scaffolding.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author yt
 * @Date 2021/12/27 4:34 下午
 */
@Data
public class StatusCountVO implements Serializable {

    private static final long serialVersionUID = 2884994434690247601L;
    private Integer type;
    private Integer count;
}
