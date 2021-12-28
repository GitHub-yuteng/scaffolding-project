package com.scaffolding.controller.extension.visit;

import com.scaffolding.auth.UserInfo;
import com.scaffolding.constant.path.GlobalPathConstant;
import com.scaffolding.controller.extension.visit.req.VisitClockReq;
import com.scaffolding.exception.AppException;
import com.scaffolding.global.response.ResponseResult;
import com.scaffolding.service.visit.TmVisitContext;
import com.scaffolding.service.visit.vo.VisitVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: yt
 * @Date: 2021/07/01/10:21
 * @Description: 终端拜访
 */
@Slf4j
@RestController
@RequestMapping(value = GlobalPathConstant.INTERCEPT_PATH + GlobalPathConstant.VERSION_1 + GlobalPathConstant.VISIT_PATH)
public class TmVisitController {

    @Autowired
    private TmVisitContext tmVisitContext;

    /**
     * 拜访到店/离店 打卡
     *
     * @param visitClockReq
     * @return
     */
    @PostMapping(value = "/clock")
    public ResponseResult<VisitVO> tmVisitClock(@RequestBody @Valid VisitClockReq visitClockReq) {
        try {
            log.info("TmVisitController#tmVisitClock: 拜访到店/离店 打卡, param:{}", visitClockReq.toString());
            VisitVO visitVO = tmVisitContext.tmVisitClock(visitClockReq);
            return ResponseResult.success(visitVO);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("TmVisitController#tmVisitClock: Error -> Exception:{}, 拜访到店/离店 打卡, param:{}",
                    e.getMessage(), visitClockReq.toString());
            return ResponseResult.fail(e.getMessage());
        }
    }
}
