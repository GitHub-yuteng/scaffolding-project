package com.scaffolding.controller.refund;

import com.alibaba.fastjson.JSON;
import com.whhim.hxh.aspect.RepeatSubmit;
import com.whhim.hxh.auth.Authentication;
import com.whhim.hxh.auth.UserInfo;
import com.whhim.hxh.constant.GlobalConstant;
import com.whhim.hxh.constant.path.GlobalPathConstant;
import com.whhim.hxh.controller.refund.req.RefundDetailReq;
import com.whhim.hxh.controller.refund.req.RefundListReq;
import com.whhim.hxh.controller.refund.vo.RefundItemVO;
import com.whhim.hxh.controller.refund.vo.detail.RefundDetailVO;
import com.whhim.hxh.controller.refund.vo.detail.RefundSelectTypeVO;
import com.whhim.hxh.exception.AppException;
import com.whhim.hxh.global.response.ResponseResult;
import com.whhim.hxh.pojo.vo.BasePageVO;
import com.whhim.hxh.service.refund.RefundInfoContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/25 10:49 上午
 */
@Slf4j
@RestController
@RequestMapping(value = GlobalPathConstant.INTERCEPT_PATH + GlobalPathConstant.REFUND_PATH + GlobalPathConstant.VERSION_1)
public class RefundInfoController {

    @Autowired
    private RefundInfoContext refundInfoContext;

    /**
     * 选择售后类型
     * @return
     */
    @RepeatSubmit
    @PostMapping(value = "/refundType")
    public ResponseResult<RefundSelectTypeVO> refundType(@RequestBody RefundDetailReq refundDetailReq){
        try {
            log.info("RefundInfoController#refundType: 选择售后类型, param:{}", JSON.toJSONString(refundDetailReq));
            UserInfo userInfo = Authentication.getUserInfo();
            RefundSelectTypeVO result = refundInfoContext.refundType(refundDetailReq, userInfo);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("RefundInfoController#refundType, 选择售后类型, param:{}, Exception:{}", JSON.toJSONString(refundDetailReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

    /**
     * 申请售后
     * @return
     */
    @PostMapping(value = "/applyRefund")
    public ResponseResult<RefundDetailVO> applyRefund(@RequestBody RefundDetailReq refundDetailReq){
        try {
            log.info("RefundInfoController#applyRefund: 申请售后, param:{}", JSON.toJSONString(refundDetailReq));
            UserInfo userInfo = Authentication.getUserInfo();
            RefundDetailVO result = refundInfoContext.applyRefund(refundDetailReq, userInfo);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("RefundInfoController#applyRefund, 申请售后, param:{}, Exception:{}", JSON.toJSONString(refundDetailReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

    /**
     * 售后列表
     * @return
     */
    @PostMapping(value = "/refundList")
    public ResponseResult<BasePageVO<RefundItemVO>> queryRefundList(@RequestBody RefundListReq refundListReq){
        try {
            log.info("RefundInfoController#queryOrderList: 获取售后列表请求, param:{}", JSON.toJSONString(refundListReq));
            UserInfo userInfo = Authentication.getUserInfo();
            BasePageVO<RefundItemVO> result = refundInfoContext.queryRefundList(refundListReq, userInfo);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("RefundInfoController#queryOrderDetail, 获取售后列表请求, param:{}, Exception:{}", JSON.toJSONString(refundListReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

    /**
     * 售后详情
     * @return
     */
    @PostMapping(value = "/refundDetail")
    public ResponseResult<RefundDetailVO> queryRefundDetail(@RequestBody RefundDetailReq refundDetailReq){
        try {
            log.info("RefundInfoController#queryOrderList: 获取售后详情请求, param:{}", JSON.toJSONString(refundDetailReq));
            UserInfo userInfo = Authentication.getUserInfo();
            RefundDetailVO result = refundInfoContext.queryRefundDetail(refundDetailReq, userInfo);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("RefundInfoController#queryOrderDetail, 获取售后详情请求, param:{}, Exception:{}", JSON.toJSONString(refundDetailReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

    /**
     * 订单售后历史
     * @return
     */
    @PostMapping(value = "/refundHistory")
    public ResponseResult<BasePageVO<RefundItemVO>> queryRefundHistory(@RequestBody RefundListReq refundListReq){
        try {
            log.info("RefundInfoController#queryRefundHistory: 订单售后历史, param:{}", JSON.toJSONString(refundListReq));
            UserInfo userInfo = Authentication.getUserInfo();
            BasePageVO<RefundItemVO> result = refundInfoContext.queryRefundHistory(refundListReq, userInfo);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("RefundInfoController#queryRefundHistory, 订单售后历史, param:{}, Exception:{}", JSON.toJSONString(refundListReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }
}
