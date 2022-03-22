package com.scaffolding.controller.product.req;

import com.whhim.hxh.pojo.req.BasePageReq;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/9 6:56 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductListReq extends BasePageReq {

    /**
     * 搜索关键词
     */
    private String searchKey;
}
