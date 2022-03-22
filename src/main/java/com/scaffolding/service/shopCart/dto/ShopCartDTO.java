package com.scaffolding.service.shopCart.dto;

import com.scaffolding.controller.order.vo.confirm.StoreProductVO;
import lombok.Data;

import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/8 2:33 下午
 */
@Data
public class ShopCartDTO {

    private String version;
    private List<StoreProductVO> storeProductList;
}
