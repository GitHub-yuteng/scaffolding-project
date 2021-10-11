package com.scaffolding.controller.order;

import com.scaffolding.constant.OrderInfoConstant;
import com.scaffolding.constant.path.PathGlobalConstant;
import com.scaffolding.controller.order.req.OrderListReq;
import com.scaffolding.exception.AppException;
import com.scaffolding.pojo.vo.BasePageVO;
import com.scaffolding.pojo.vo.order.list.OrderItemVO;
import com.scaffolding.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @Author: yt
 * @Date: 2021/06/02/15:03
 * @Description:
 * @module 模式订单
 */
@Slf4j
@RestController
@RequestMapping(value = PathGlobalConstant.INTERCEPT_PATH + PathGlobalConstant.ORDER_PATH)
public class OrderInfoController {

    /**
     * 获取订单列表
     *
     * @param orderListReq
     * @param response
     * @return
     */
    @PostMapping(value = "/orderList")
    public ResponseResult<BasePageVO<OrderItemVO>> queryOrderList(@RequestBody @Valid OrderListReq orderListReq, HttpServletResponse response) {
        try {
            log.info("OrderInfoController#queryOrderList: 获取订单列表请求, param:{}", orderListReq.toString());
            return ResponseResult.success();
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("OrderInfoController#queryOrderDetail, 获取订单列表, param:{}, Exception:{}", orderListReq.toString(), e.getMessage());
            return ResponseResult.fail(OrderInfoConstant.ORDER_ERROR_RETURN);
        }
    }
}
