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

    private String id;
    private String username;
    private String icon;
    private String token;

}
