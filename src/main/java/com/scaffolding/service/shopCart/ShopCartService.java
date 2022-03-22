package com.scaffolding.service.shopCart;

import com.whhim.hxh.controller.shopCart.req.OperationCartReq;
import com.whhim.hxh.controller.shopCart.vo.ShopCartVO;
import com.whhim.hxh.redis.RedisService;
import com.whhim.hxh.service.shopCart.dto.ShopCartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Description: 购物车 命令模式操控购物车+观察者模式察觉变化操作完主动查询购物车返回
 * @Author whh-yt
 * @Date 2022/3/8 2:46 下午
 */
@Service
public class ShopCartService {

    @Autowired
    private RedisService redisService;
    @Autowired
    private CommonShopCartService commonShopCartService;

    public ShopCartVO queryUserShopCart() {
        ShopCartDTO shopCartDTO = commonShopCartService.getUserShopCart();
        //计算营销等


        return ShopCartService.transformCart(shopCartDTO);
    }

    public ShopCartVO operationShopCart(OperationCartReq operationCartReq) {

        return null;

    }

    public static ShopCartVO transformCart(ShopCartDTO shopCartDTO) {
        ShopCartVO shopCartVO = new ShopCartVO();
        if (Objects.isNull(shopCartDTO)) {
            return shopCartVO;
        }
        shopCartVO.setVersion(shopCartDTO.getVersion());
        shopCartVO.setStoreProductList(shopCartDTO.getStoreProductList());
        return shopCartVO;
    }
}
