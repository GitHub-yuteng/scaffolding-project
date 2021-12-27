package com.scaffolding.controller.extension.visit.req;

import com.scaffolding.auth.UserInfo;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/07/02/11:00
 * @Description:
 */
@Data
public class VisitListReq implements Serializable {

    private static final long serialVersionUID = -8308969676127858878L;

    /**
     * 搜索词 / 店铺名称
     */
    private String searchKey;
    /**
     * 本人当前经度
     */
    @NotNull(message = "经度不能为空")
    private String longitude;
    /**
     * 本人当前纬度
     */
    @NotNull(message = "维度不能为空")
    private String latitude;

    /**
     * 当前请求用户信息
     */
    private UserInfo userInfo;
}
