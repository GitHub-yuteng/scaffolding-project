package com.scaffolding.auth;

import lombok.Data;

import java.io.Serializable;

/**
 * @author whh-yt
 * @Date 2021/10/20
 * @Desc
 */
@Data
public class UserInfo implements Serializable {

    private String id;
    private String name;
}
