package com.scaffolding.service.visit.report;

import com.scaffolding.auth.UserInfo;
import com.scaffolding.controller.extension.visit.req.report.VisitReportReq;
import com.scaffolding.service.visit.dto.VisitParamDTO;
import com.scaffolding.service.visit.vo.report.TmVisitReportVO;

/**
 * @Description: TODO
 * @Author yt
 * @Date 2021/12/28 1:51 下午
 */
public abstract class AbstractVisitProcessor {

    /**
     * 上级
     */
    protected AbstractVisitProcessor superiorProcessor;
    /**
     * 下级
     */
    protected AbstractVisitProcessor subordinateProcessor;

    /**
     * 处理人责任链
     *
     * @param superiorProcessor
     * @param subordinateProcessor
     * @return
     */
    public final AbstractVisitProcessor applyVisitProcessor(AbstractVisitProcessor superiorProcessor, AbstractVisitProcessor subordinateProcessor) {
        this.superiorProcessor = superiorProcessor;
        this.subordinateProcessor = subordinateProcessor;
        return subordinateProcessor;
    }

    /**
     * 处理流程
     *
     * @param visitReportReq
     * @param visitParam
     * @param userInfo
     * @return
     * @throws Exception
     */
    public abstract TmVisitReportVO processRequest(VisitReportReq visitReportReq, VisitParamDTO visitParam, UserInfo userInfo) throws Exception;

}
