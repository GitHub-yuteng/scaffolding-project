package com.scaffolding.service.visit.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/07/02/11:10
 * @Description:
 */
@Data
public class TmVisitDetailVO extends TmVisitVO implements Serializable {

    private static final long serialVersionUID = 2763987919737487032L;
    /**
     * 允许打卡类别(1:到店打卡，2:离店打卡,3:不允许打卡, 4: 外部其他人员跳转查询，不显示打卡按钮)
     */
    private Integer allowClock;
    /**
     * 打卡信息
     */
    private TmVisitClockVO tmVisitClock;

}
