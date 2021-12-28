package com.scaffolding.service.visit.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yt
 * @Date 2021/9/29
 * @Desc
 */
@Data
public class VisitVO implements Serializable {

    private static final long serialVersionUID = -8788570537663238603L;

    /**
     * 拜访序号
     */
    private Integer visitNo;
    /**
     * 拜访类别(计划1 /无计划 2)
     */
    private Integer ifPlan;
    /**
     * 拜访类别(到店，离店)
     */
    private Integer visitClockType;
    /**
     * 拜访类别(到店，离店)
     */
    private String visitClock;
}
