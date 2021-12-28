package com.scaffolding.service.visit;

import com.scaffolding.controller.extension.visit.req.VisitClockReq;
import com.scaffolding.service.visit.clock.NoPlanTmVisitService;
import com.scaffolding.service.visit.clock.PlanTmVisitService;
import com.scaffolding.service.visit.vo.VisitVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2021/12/27 6:41 下午
 */
@Component
public class TmVisitContext {

    @Autowired
    private NoPlanTmVisitService noPlanTmVisitService;
    @Autowired
    private PlanTmVisitService planTmVisitService;

    /**
     * 打卡
     * @param visitClockReq
     * @return
     */
    public VisitVO tmVisitClock(VisitClockReq visitClockReq) {
        Integer clockTarget = visitClockReq.getClockTarget();
        return null;
    }
}
