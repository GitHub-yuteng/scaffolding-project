package com.scaffolding.controller.order.vo.confirm;

import com.whhim.hxh.controller.product.vo.ProductVO;
import com.whhim.hxh.controller.store.vo.StoreVO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/15 1:07 下午
 */
@Data
public class StoreProductVO {

    @NotNull(message = "店铺信息为空")
    private StoreVO store;
    @NotNull(message = "商品信息为空")
    private List<ProductVO> productList;
}
