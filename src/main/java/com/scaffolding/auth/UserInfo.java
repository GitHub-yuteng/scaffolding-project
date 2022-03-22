package com.scaffolding.auth;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yt
 * @Date 2021/10/20
 * @Desc
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -7812362499262764763L;

    private Long id;
    private String openId;
    private String unionId;
    private String userCode;
    private String nickname;
    private String token;
    private Integer usertype;
    private String platformSource;

}
