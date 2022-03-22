package com.scaffolding.service.shopCart.observer;

import com.whhim.hxh.controller.shopCart.vo.ShopCartVO;
import com.whhim.hxh.service.shopCart.dto.ShopCartDTO;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/9 9:52 上午
 */
@Service
public class ShopCartObserver implements CartObserver {

    @Override
    public ShopCartVO change(ShopCartDTO shopCartDTO) {
        ShopCartVO shopCartVO = new ShopCartVO();
        shopCartVO.setVersion(shopCartDTO.getVersion());
        shopCartVO.setStoreProductList(shopCartDTO.getStoreProductList());
        return shopCartVO;
    }
}
