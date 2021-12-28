package com.scaffolding.service.visit.clock;

import com.scaffolding.auth.UserInfo;
import com.scaffolding.controller.extension.visit.req.VisitClockReq;
import com.scaffolding.service.visit.IVisitClock;
import com.scaffolding.service.visit.vo.VisitVO;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2021/12/27 6:49 下午
 */
@Service
public class NoPlanTmVisitService extends TmVisitService implements IVisitClock {

    @Override
    public VisitVO arriveClock(VisitClockReq visitClockReq, UserInfo userInfo) {
        return null;
    }

    @Override
    public VisitVO leaveClock(VisitClockReq visitClockReq, UserInfo userInfo) {
        return null;
    }
}
