package com.scaffolding.controller.order;

import com.alibaba.fastjson.JSON;
import com.scaffolding.auth.UserInfo;
import com.scaffolding.constant.path.GlobalPathConstant;
import com.scaffolding.controller.order.vo.OrderTargetVO;
import com.scaffolding.global.response.ResponseResult;
import com.scaffolding.pojo.req.EmptyReq;
import com.scaffolding.service.order.OrderInfoContext;
import com.whhim.hxh.auth.Authentication;
import com.whhim.hxh.constant.GlobalConstant;
import com.whhim.hxh.controller.order.req.OrderListReq;
import com.whhim.hxh.controller.order.vo.OrderItemVO;
import com.whhim.hxh.exception.AppException;
import com.whhim.hxh.pojo.vo.BasePageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/11 10:04 上午
 */
@Slf4j
@RestController
@RequestMapping(value = GlobalPathConstant.INTERCEPT_PATH + GlobalPathConstant.SHARE_ORDER_PATH + GlobalPathConstant.VERSION_1)
public class OrderShareController {

    @Autowired
    private OrderInfoContext orderInfoContext;

    public final static String ORDER_TYPE = "SHARE";

    /**
     * 获取订单查询标签
     *
     * @return
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
     * 获取订单列表
     *
     * @param orderListReq
     * @return
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
}
