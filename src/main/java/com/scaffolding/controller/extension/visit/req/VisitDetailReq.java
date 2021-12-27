package com.scaffolding.controller.extension.visit.req;

import com.scaffolding.auth.UserInfo;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author whh-yt
 */
@Data
public class VisitDetailReq implements Serializable {

    private static final long serialVersionUID = 9063391973042413860L;

    /**
     * 拜访类别(计划 1/无计划 2)
     */
    @NotNull(message = "拜访类别不能为空")
    private Integer ifPlan;
    /**
     * 拜访序号
     */
    @NotNull(message = "拜访序号不能为空")
    private Integer visitNo;
    /**
     * 本人位置经度
     */
    @NotNull(message = "定位异常")
    private String longitude;
    /**
     * 本人位置纬度
     */
    @NotNull(message = "定位异常")
    private String latitude;
    /**
     * 终端代码(T码)
     */
    @NotNull(message = "终端代码不能为空")
    private String tmNo;
    /**
     * 5000w代码
     */
    @NotNull(message = "终端代码不能为空")
    private String scCode;
    /**
     * 是否本人查询
     */
    private Integer self;
    /**
     * 当前请求用户信息
     */
    private UserInfo userInfo;

}
