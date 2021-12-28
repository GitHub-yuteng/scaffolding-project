package com.scaffolding.service.visit.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yt
 * @Date 2021/8/25
 */
@Data
public class ClockInfoVO implements Serializable {

    private static final long serialVersionUID = 3251525621160909619L;

    private String fileUrl;
    /**
     * 到店/离店 时间
     */
    private String visitTime;
    /**
     * 地址详细信息
     */
    private String detailAddress;
    /**
     * 备注
     */
    private String note;
    /**
     * 地图类型(高德地图：amap,腾讯地图：TencentMap)
     */
    private String mapType;

}
