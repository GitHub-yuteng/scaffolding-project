package com.scaffolding.controller.extension.visit.req;

import com.scaffolding.pojo.req.AddressReq;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/08/06/15:33
 * @Description:
 */
@Data
public class VisitClockReq implements Serializable {

    private static final long serialVersionUID = 9175479361480300547L;

    /**
     * 打卡类型(到店：0，离店：1)
     */
    @NotNull(message = "打卡类型异常")
    private Integer clockTarget;
    /**
     * 拜访类别(计划 1/无计划 2)
     */
    @NotNull(message = "拜访类别不能为空")
    private Integer ifPlan;
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
    @NotNull(message = "地址不能为空")
    private AddressReq addressReq;
    /**
     * 到店凭证
     */
    private VisitSceneReq arriveScene;
    /**
     * 店内场景
     */
    private VisitSceneReq storeScene;
    /**
     * 离店凭证
     */
    private VisitSceneReq leaveScene;
    /**
     * 备注
     */
    private String note;
    /**
     * 地图类型(高德地图：amap,腾讯地图：TencentMap)
     */
    private String mapType;
}
