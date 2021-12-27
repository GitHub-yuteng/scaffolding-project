package com.scaffolding.service.visit;

import com.scaffolding.auth.UserInfo;
import com.scaffolding.controller.extension.visit.req.VisitClockReq;
import com.scaffolding.controller.extension.visit.req.VisitDetailReq;
import com.scaffolding.controller.extension.visit.req.VisitListReq;
import com.scaffolding.service.visit.vo.TmVisitDetailVO;
import com.scaffolding.service.visit.vo.TmVisitVO;
import com.scaffolding.service.visit.vo.VisitVO;

import java.util.List;

/**
 * @author whh-yt
 * @Date 2021/8/26
 */
public abstract class AbstractTmVisit {

    /**
     * 获取拜访终端列表
     *
     * @param visitListReq
     * @param userInfo
     * @return
     */
    public abstract List<TmVisitVO> queryTmVisitInfoList(VisitListReq visitListReq, UserInfo userInfo) throws Exception;

    /**
     * 获取拜访终端详情
     *
     * @param visitDetailReq
     * @param userInfo
     * @return
     */
    public abstract TmVisitDetailVO queryTmVisitInfoDetails(VisitDetailReq visitDetailReq, UserInfo userInfo) throws Exception;

    /**
     * 当天未完成拜访的列表
     *
     * @param visitListReq
     * @param userInfo
     * @return
     */
    public abstract List<TmVisitVO> queryUnfinishedVisitList(VisitListReq visitListReq, UserInfo userInfo);

    /**
     * 处理前置打卡类型
     * @param visitClockReq
     * @param userInfo
     */
    public abstract VisitVO tmVisitClock(VisitClockReq visitClockReq, UserInfo userInfo);

}
