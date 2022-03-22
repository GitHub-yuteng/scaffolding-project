package com.scaffolding.controller.order.vo.detail;

import com.whhim.hxh.pojo.bean.AddressBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/14 1:50 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReceivedAddressVO extends AddressBean {

    @NotNull(message = "请选择收货地址")
    private Long id;
    private String contacts;
    private String telephone;
    private Integer ifDefault;

}