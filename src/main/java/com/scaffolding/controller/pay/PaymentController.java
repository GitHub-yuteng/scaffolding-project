package com.scaffolding.controller.pay;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whhim.hxh.auth.Authentication;
import com.whhim.hxh.auth.UserInfo;
import com.whhim.hxh.constant.GlobalConstant;
import com.whhim.hxh.constant.path.GlobalPathConstant;
import com.whhim.hxh.controller.pay.req.PayOrderReq;
import com.whhim.hxh.enums.PlatformEnum;
import com.whhim.hxh.enums.UserTypeEnum;
import com.whhim.hxh.exception.AppException;
import com.whhim.hxh.global.response.ResponseResult;
import com.whhim.hxh.mapper.HxhOrderDetailMapper;
import com.whhim.hxh.mapper.HxhOrderMapper;
import com.whhim.hxh.mapper.HxhPaymentBillMapper;
import com.whhim.hxh.payment.enums.PayPatternEnums;
import com.whhim.hxh.pojo.entity.HxhOrderDetailEntity;
import com.whhim.hxh.pojo.entity.HxhOrderEntity;
import com.whhim.hxh.pojo.entity.HxhPaymentBillEntity;
import com.whhim.hxh.service.order.CommonOrderService;
import com.whhim.hxh.service.order.enums.OrderStatusEnum;
import com.whhim.hxh.util.OrderUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/15 4:46 下午
 */
@Slf4j
@RestController
@RequestMapping(value = GlobalPathConstant.INTERCEPT_PATH + GlobalPathConstant.PAY_PATH + GlobalPathConstant.VERSION_1)
public class PaymentController {


    @Autowired
    private HxhPaymentBillMapper hxhPaymentBillMapper;
    @Autowired
    private HxhOrderMapper hxhOrderMapper;
    @Autowired
    private HxhOrderDetailMapper hxhOrderDetailMapper;
    @Autowired
    private CommonOrderService commonOrderService;

    /**
     * 支付 订单信息
     */
    @PostMapping(value = "/order")
    public ResponseResult<String> paymentOrder(@RequestBody PayOrderReq payOrderReq) {
        try {
            log.info("PaymentController#paymentOrder: 支付订单信息, param:{}", JSON.toJSONString(payOrderReq));
            List<String> orderNoList = payOrderReq.getOrderNoList();

            UserInfo userInfo = Authentication.getUserInfo();
            userInfo.setId(1L);
            userInfo.setOpenId("oappW5Ssg_j9zEz2xjSvZDZJDEAc");
            userInfo.setUnionId("oXeJp5hRUNk_0T4o6sOo80D3nHPg");
            userInfo.setUserCode("oXeJp5hRUNk_0T4o6sOo80D3nHPg");
            userInfo.setNickname("123");
            userInfo.setToken("");
            userInfo.setUsertype(UserTypeEnum.CONSUMER.getType());
            userInfo.setPlatformSource(PlatformEnum.WECHAT.getPlatformCode());
            String unionId = userInfo.getUnionId();
            List<HxhOrderEntity> orderEntityList = commonOrderService.listOrder(orderNoList);
            for (HxhOrderEntity hxhOrderEntity : orderEntityList) {
                String paymentNo = OrderUtils.createOrderNo();
                String orderNo = hxhOrderEntity.getOrderNo();
                HxhPaymentBillEntity hxhPaymentBillEntity = new HxhPaymentBillEntity();
                hxhPaymentBillEntity.setPaymentNo("P" + paymentNo);
                hxhPaymentBillEntity.setOrderNo(orderNo);
                hxhPaymentBillEntity.setPayStatus(1);
                hxhPaymentBillEntity.setSubmitBy(unionId);
                hxhPaymentBillEntity.setPayPattern(PayPatternEnums.WECHAT.getPayPattern());
                hxhPaymentBillEntity.setPayAmount(hxhOrderEntity.getPayAmount());
                hxhPaymentBillEntity.setSubmitTime(LocalDateTime.now());
                hxhPaymentBillEntity.setFee(BigDecimal.ZERO.add(BigDecimal.ONE));
                int insert = hxhPaymentBillMapper.insert(hxhPaymentBillEntity);

                HxhOrderEntity orderStatusEntity = new HxhOrderEntity();
                orderStatusEntity.setOrderStatus(OrderStatusEnum.WAIT_SEND.getType());
                hxhOrderMapper.update(orderStatusEntity, new QueryWrapper<HxhOrderEntity>().lambda().eq(HxhOrderEntity::getOrderNo, orderNo));
                HxhOrderDetailEntity orderDetailEntity = new HxhOrderDetailEntity();
                orderDetailEntity.setProductStatus(OrderStatusEnum.WAIT_SEND.getType());
                hxhOrderDetailMapper.update(orderDetailEntity, new QueryWrapper<HxhOrderDetailEntity>().lambda().eq(HxhOrderDetailEntity::getOrderNo, orderNo));
            }
            return ResponseResult.success();
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("PaymentController#paymentOrder, 支付订单信息, param:{}, Exception:{}", JSON.toJSONString(payOrderReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

}
