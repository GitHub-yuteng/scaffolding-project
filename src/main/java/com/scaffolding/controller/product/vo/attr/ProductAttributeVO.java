package com.scaffolding.controller.product.vo.attr;

import lombok.Data;

import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/11 3:01 下午
 */
@Data
public class ProductAttributeVO {

    private String attrKey;
    private List<Attribute> attributeList;

    @Data
    public static class Attribute {
        private String attribute;
        private List<String> skuCodeList;
    }
}
