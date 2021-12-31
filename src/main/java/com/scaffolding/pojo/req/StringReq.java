package com.scaffolding.pojo.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author yt
 * @Date 2021/12/27 4:19 下午
 */
@Data
public class StringReq implements Serializable {

    private static final long serialVersionUID = -7094545048883940378L;

    private String code;
}
