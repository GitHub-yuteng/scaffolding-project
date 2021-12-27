package com.scaffolding.service.visit.clock;

import com.scaffolding.auth.UserInfo;
import com.scaffolding.controller.extension.visit.req.VisitClockReq;
import com.scaffolding.controller.extension.visit.req.VisitDetailReq;
import com.scaffolding.controller.extension.visit.req.VisitListReq;
import com.scaffolding.service.visit.AbstractTmVisit;
import com.scaffolding.service.visit.ITmVisitClock;
import com.scaffolding.service.visit.vo.TmVisitDetailVO;
import com.scaffolding.service.visit.vo.TmVisitVO;
import com.scaffolding.service.visit.vo.VisitVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author whh-yt
 * @Date 2021/8/26
 */
@Service
public class TmVisitService extends AbstractTmVisit implements ITmVisitClock {

    @Override
    public List<TmVisitVO> queryTmVisitInfoList(VisitListReq visitListReq, UserInfo userInfo) throws Exception {
        return null;
    }

    @Override
    public TmVisitDetailVO queryTmVisitInfoDetails(VisitDetailReq visitDetailReq, UserInfo userInfo) throws Exception {
        return null;
    }

    @Override
    public List<TmVisitVO> queryUnfinishedVisitList(VisitListReq visitListReq, UserInfo userInfo) {
        return null;
    }

    @Override
    public VisitVO tmVisitClock(VisitClockReq visitClockReq, UserInfo userInfo) {
        return null;
    }

    @Override
    public VisitVO arriveClock(VisitClockReq visitClockReq, UserInfo userInfo) {
        return null;
    }

    @Override
    public VisitVO leaveClock(VisitClockReq visitClockReq, UserInfo userInfo) {
        return null;
    }
}
