package com.scaffolding.service.visit;


import com.scaffolding.auth.UserInfo;
import com.scaffolding.controller.extension.visit.req.VisitClockReq;
import com.scaffolding.service.visit.vo.VisitVO;

/**
 * @author whh-yt
 * @Date 2021/8/26
 */
public interface IVisitClock {

    /**
     * 到店打卡
     * @param visitClockReq
     * @param userInfo
     */
    VisitVO arriveClock(VisitClockReq visitClockReq, UserInfo userInfo);

    /**
     * 离店打卡
     * @param visitClockReq
     * @param userInfo
     */
    VisitVO leaveClock(VisitClockReq visitClockReq,UserInfo userInfo);


}
