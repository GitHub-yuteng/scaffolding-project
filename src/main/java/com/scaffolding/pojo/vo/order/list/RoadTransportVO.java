package com.scaffolding.pojo.vo.order.list;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author whh-yt
 * @Date 2021/8/13
 */
@Data
@Builder
public class RoadTransportVO implements Serializable {

    private static final long serialVersionUID = 1085276294009185711L;
    /**
     * 发货方式
     */
    private String deliveryMethod;
    /**
     * 发货地址
     */
    private String deliveryAddress;
    /**
     * 物流单号
     */
    private String expressCode;
    /**
     * 运输人
     */
    private String carrier;
    /**
     * 运输人联系方式
     */
    private String telephone;
    /**
     * 车牌号
     */
    private String carPlate;
    /**
     * 车牌号url
     */
    private List<String> carPlateUrl;
}
