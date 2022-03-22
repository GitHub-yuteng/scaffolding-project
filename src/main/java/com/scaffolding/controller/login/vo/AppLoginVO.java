package com.scaffolding.controller.login.vo;

import com.whhim.hxh.auth.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/21 7:21 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppLoginVO implements Serializable {

    private UserInfo userInfo;

}
