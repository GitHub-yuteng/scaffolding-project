package com.scaffolding.pojo.vo.express;

import lombok.Data;

import java.io.Serializable;

/**
 * @author whh-yt
 */
@Data
public class ExpressVO implements Serializable {
    /**
     * 当前物流状态(同 StateEx)
     */
    private String action;
    /**
     * 轨迹描述
     */
    private String acceptStation;
    /**
     * 轨迹发生时间
     */
    private String acceptTime;
    /**
     * 当前城市
     */
    private String location;
}
