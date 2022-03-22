package com.scaffolding.controller.product;

import com.alibaba.fastjson.JSON;
import com.whhim.hxh.auth.Authentication;
import com.whhim.hxh.auth.UserInfo;
import com.whhim.hxh.constant.GlobalConstant;
import com.whhim.hxh.constant.path.GlobalPathConstant;
import com.whhim.hxh.controller.product.req.ProductDetailReq;
import com.whhim.hxh.controller.product.req.ProductListReq;
import com.whhim.hxh.controller.product.vo.ProductDetailVO;
import com.whhim.hxh.controller.product.vo.ProductVO;
import com.whhim.hxh.exception.AppException;
import com.whhim.hxh.global.response.ResponseResult;
import com.whhim.hxh.pojo.vo.BasePageVO;
import com.whhim.hxh.service.product.ProductInfoContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 商详
 * @Author whh-yt
 * @Date 2022/2/28 8:49 上午
 */
@Slf4j
@RestController
@RequestMapping(value = GlobalPathConstant.INTERCEPT_PATH + GlobalPathConstant.PRODUCT_PATH + GlobalPathConstant.VERSION_1)
public class ProductController {

    @Autowired
    private ProductInfoContext productInfoContext;

    /**
     * 商品列表
     *
     * @return
     */
    @PostMapping(value = "/list")
    public ResponseResult<BasePageVO<ProductVO>> queryProductList(@RequestBody ProductListReq productListReq) {
        try {
            log.info("ProductController#queryProductList: 商品列表, param:{}", JSON.toJSONString(productListReq));
            UserInfo userInfo = Authentication.getUserInfo();
            BasePageVO<ProductVO> result = productInfoContext.queryProductList(productListReq, userInfo);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("ProductController#queryProductList, 商品列表, param:{}, Exception:{}", JSON.toJSONString(productListReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

    /**
     * 详情
     * @return
     */
    @PostMapping(value = "/detail")
    public ResponseResult<ProductDetailVO> queryProductDetail(@RequestBody ProductDetailReq productDetailReq) {
        try {
            log.info("ProductController#queryProductList: 商品详情, param:{}", JSON.toJSONString(productDetailReq));
            UserInfo userInfo = Authentication.getUserInfo();
            ProductDetailVO result = productInfoContext.queryProductDetail(productDetailReq, userInfo);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("ProductController#queryProductList, 商品详情, param:{}, Exception:{}", JSON.toJSONString(productDetailReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

}
