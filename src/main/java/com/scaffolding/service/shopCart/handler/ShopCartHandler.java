package com.scaffolding.service.shopCart.handler;

import com.whhim.hxh.auth.Authentication;
import com.whhim.hxh.auth.UserInfo;
import com.whhim.hxh.controller.order.req.confirm.OrderCommitReq;
import com.whhim.hxh.controller.order.req.confirm.OrderConfirmReq;
import com.whhim.hxh.controller.order.vo.confirm.ConfirmOrderVO;
import com.whhim.hxh.controller.product.vo.ProductVO;
import com.whhim.hxh.redis.RedisService;
import com.whhim.hxh.redis.prefix.ShopCartKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 购物车确认订单/提交订单 处理器 处理购物车商品信息/删除购物车商品信息
 * @Author whh-yt
 * @Date 2022/3/9 4:12 下午
 */
@Component
public class ShopCartHandler {

    @Autowired
    private RedisService redisService;

    /**
     * @param orderConfirmReq
     * @param confirmOrderVO
     */
    public void confirmOrder(OrderConfirmReq orderConfirmReq, ConfirmOrderVO confirmOrderVO) {
        UserInfo userInfo = Authentication.getUserInfo();
        String s = redisService.get(ShopCartKey.SHOP_CART_KEY, userInfo.getUnionId());

    }

    /**
     * 删除购物车商品
     */
    public void commitOrder(OrderCommitReq orderCommitReq) {
        UserInfo userInfo = Authentication.getUserInfo();
        ProductVO productVO = redisService.get(ShopCartKey.SHOP_CART_KEY, userInfo.getUnionId(), ProductVO.class);


    }
}
