package com.scaffolding.service.visit.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/08/06/15:40
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TmVisitClockVO {

    /**
     * 到店信息
     */
    private ClockInfoVO arriveClock;
    /**
     * 陈列图片
     */
    private List<String> tmScenePicList;
    /**
     * 离店信息
     */
    private ClockInfoVO leaveClock;



}
