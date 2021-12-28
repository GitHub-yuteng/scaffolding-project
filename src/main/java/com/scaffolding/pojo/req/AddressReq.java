package com.scaffolding.pojo.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yt
 * @Date 2021/8/30
 * @Desc 省市区
 */
@Data
public class AddressReq implements Serializable {

    /**
     * 省
     */
    private String provinceCode;
    private String province;
    /**
     * 市
     */
    private String cityCode;
    private String city;
    /**
     * 区县
     */
    private String districtCode;
    private String district;
    /**
     * 街道
     */
    private String street;
    /**
     * 位置
     */
    private String position;

    public String getAddressDetail() {
        return province + city + district + street;
    }
}
