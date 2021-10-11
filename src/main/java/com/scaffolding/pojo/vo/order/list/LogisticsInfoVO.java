package com.scaffolding.pojo.vo.order.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/04/15/18:53
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogisticsInfoVO implements Serializable {

    private static final long serialVersionUID = 1619868165216661868L;

    private String expressNo;
    private String expressCode;
    private String expressName;
    /**
     * 运输类型 1：快递运输 2:公路运输
     */
    private Integer deliveryMethodType;
    private RoadTransportVO roadTransportVO;

}
