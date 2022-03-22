package com.scaffolding.service.shopCart;

import com.whhim.hxh.auth.Authentication;
import com.whhim.hxh.auth.UserInfo;
import com.whhim.hxh.redis.RedisService;
import com.whhim.hxh.redis.prefix.ShopCartKey;
import com.whhim.hxh.service.shopCart.dto.ShopCartDTO;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/25 10:16 上午
 */
@Component
public class CommonShopCartService {

    private RedisService redisService;

    public ShopCartDTO getUserShopCart(){
        UserInfo userInfo = Authentication.getUserInfo();
        return redisService.get(ShopCartKey.SHOP_CART_KEY, userInfo.getUnionId(), ShopCartDTO.class);
    }
}
