package com.scaffolding.controller.order;

import cn.hutool.json.JSON;
import com.scaffolding.auth.Authentication;
import com.scaffolding.auth.UserInfo;
import com.scaffolding.constant.GlobalConstant;
import com.scaffolding.constant.path.GlobalPathConstant;
import com.scaffolding.controller.order.req.OrderDetailReq;
import com.scaffolding.controller.order.req.OrderListReq;
import com.scaffolding.controller.order.req.confirm.OrderCommitReq;
import com.scaffolding.controller.order.req.confirm.OrderConfirmReq;
import com.scaffolding.controller.order.vo.OrderCommitVO;
import com.scaffolding.controller.order.vo.OrderItemVO;
import com.scaffolding.controller.order.vo.OrderTargetVO;
import com.scaffolding.controller.order.vo.confirm.ConfirmOrderVO;
import com.scaffolding.controller.order.vo.detail.OrderDetailVO;
import com.scaffolding.exception.AppException;
import com.scaffolding.global.response.ResponseResult;
import com.scaffolding.pojo.req.EmptyReq;
import com.scaffolding.pojo.vo.BasePageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/06/02/15:03
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping(value = GlobalPathConstant.INTERCEPT_PATH + GlobalPathConstant.ORDER_PATH + GlobalPathConstant.VERSION_1)
public class OrderInfoController {

    @Autowired
    private OrderInfoContext orderInfoContext;

    private final static String ORDER_TYPE = "SELF";

    /**
     * 获取订单查询标签
     */
    @PostMapping(value = "/orderTarget")
    public ResponseResult<List<OrderTargetVO>> queryOrderTarget(@RequestBody @Valid EmptyReq emptyReq) {
        try {
            log.info("OrderInfoController#queryOrderTarget: 获取订单查询标签, param:{}", JSON.toJSONString(emptyReq));
            UserInfo userInfo = Authentication.getUserInfo();
            List<OrderTargetVO> result = orderInfoContext.queryOrderTarget(ORDER_TYPE, userInfo);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("OrderInfoController#queryOrderTarget, 获取订单查询标签, param:{}, Exception:{}", JSON.toJSONString(emptyReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

    /**
     * 确认订单页(未提交) 可以增加埋点 对用户确认订单的商品进行推荐
     */
    @PostMapping(value = "/confirm")
    public ResponseResult<ConfirmOrderVO> confirmOrder(@RequestBody @Valid OrderConfirmReq orderConfirmReq) {
        try {
            log.info("OrderInfoController#commitOrder: 确认订单(未提交), param:{}", JSON.toJSONString(orderConfirmReq));
            UserInfo userInfo = Authentication.getUserInfo();
            ConfirmOrderVO result = orderInfoContext.confirmOrder(orderConfirmReq, userInfo);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("OrderInfoController#commitOrder, 确认订单(未提交), param:{}, Exception:{}", JSON.toJSONString(orderConfirmReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

    /**
     * 提交订单
     */
    @PostMapping(value = "/commit")
    public ResponseResult<OrderCommitVO> commitOrder(@RequestBody @Valid OrderCommitReq orderCommitReq) {
        try {
            log.info("OrderInfoController#commitOrder: 提交订单, param:{}", JSON.toJSONString(orderCommitReq));
            UserInfo userInfo = Authentication.getUserInfo();
            OrderCommitVO result = orderInfoContext.commitOrder(orderCommitReq, userInfo);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("OrderInfoController#commitOrder, 提交订单, param:{}, Exception:{}", JSON.toJSONString(orderCommitReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

    /**
     * 获取订单列表
     */
    @PostMapping(value = "/orderList")
    public ResponseResult<BasePageVO<OrderItemVO>> queryOrderList(@RequestBody @Valid OrderListReq orderListReq) {
        try {
            log.info("OrderInfoController#queryOrderList: 获取订单列表请求, param:{}", JSON.toJSONString(orderListReq));
            UserInfo userInfo = Authentication.getUserInfo();
            BasePageVO<OrderItemVO> result = orderInfoContext.queryOrderList(orderListReq, ORDER_TYPE, userInfo);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("OrderInfoController#queryOrderDetail, 获取订单列表, param:{}, Exception:{}", JSON.toJSONString(orderListReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

    /**
     * 获取订单详情
     */
    @PostMapping(value = "/orderDetail")
    public ResponseResult<OrderDetailVO> queryOrderDetail(@RequestBody @Valid OrderDetailReq orderDetailReq) {
        try {
            log.info("OrderInfoController#queryOrderDetail: 获取订单详情请求, param:{}", JSON.toJSONString(orderDetailReq));
            UserInfo userInfo = Authentication.getUserInfo();
            OrderDetailVO result = orderInfoContext.queryOrderDetail(orderDetailReq, userInfo);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("OrderInfoController#queryOrderDetail, 获取订单详情, param:{}, Exception:{}", JSON.toJSONString(orderDetailReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }



}
