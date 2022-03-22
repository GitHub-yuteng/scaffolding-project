package com.scaffolding.controller.shopCart.vo;

import com.whhim.hxh.controller.order.vo.confirm.StoreProductVO;
import com.whhim.hxh.controller.product.vo.ProductVO;
import com.whhim.hxh.controller.store.vo.StoreVO;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/8 2:33 下午
 */
@Data
public class ShopCartVO {

    private String version;
    private List<StoreProductVO> storeProductList;
    private String paymentAmount;

}
