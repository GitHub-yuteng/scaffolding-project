package com.scaffolding.controller.shopCart;

import com.alibaba.fastjson.JSON;
import com.whhim.hxh.auth.Authentication;
import com.whhim.hxh.auth.UserInfo;
import com.whhim.hxh.constant.GlobalConstant;
import com.whhim.hxh.constant.path.GlobalPathConstant;
import com.whhim.hxh.controller.shopCart.req.OperationCartReq;
import com.whhim.hxh.controller.shopCart.vo.ShopCartVO;
import com.whhim.hxh.exception.AppException;
import com.whhim.hxh.global.response.ResponseResult;
import com.whhim.hxh.pojo.req.EmptyReq;
import com.whhim.hxh.service.shopCart.ShopCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/8 2:31 下午
 */
@Slf4j
@RestController
@RequestMapping(value = GlobalPathConstant.INTERCEPT_PATH + GlobalPathConstant.SHOPCART_PATH + GlobalPathConstant.VERSION_1)
public class ShopCartController {

    @Autowired
    private ShopCartService shopCartService;

    /**
     * 获取购物车信息
     *
     * @return
     */
    @PostMapping(value = "/shopCart")
    public ResponseResult<ShopCartVO> queryShopCart(@RequestBody EmptyReq emptyReq) {
        try {
            log.info("ShopCartController#queryShopCart: 获取购物车信息, param:{}", JSON.toJSONString(emptyReq));
            ShopCartVO result = shopCartService.queryUserShopCart();
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("ShopCartController#queryShopCart, 获取购物车信息, param:{}, Exception:{}", JSON.toJSONString(emptyReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }


    /**
     * 操作购物车商品信息
     *
     * @return
     */
    @PostMapping(value = "/operation")
    public ResponseResult<ShopCartVO> operationShopCart(@RequestBody OperationCartReq operationCartReq) {
        try {
            log.info("ShopCartController#operationShopCart: 获取购物车信息, param:{}", JSON.toJSONString(operationCartReq));
            ShopCartVO result = shopCartService.operationShopCart(operationCartReq);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("ShopCartController#operationShopCart, 获取购物车信息, param:{}, Exception:{}", JSON.toJSONString(operationCartReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }


}
