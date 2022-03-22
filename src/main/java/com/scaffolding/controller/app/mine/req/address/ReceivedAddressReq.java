package com.scaffolding.controller.app.mine.req.address;

import com.scaffolding.pojo.bean.AddressBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/14 2:10 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReceivedAddressReq extends AddressBean {

    private static final long serialVersionUID = -9195677749185689282L;
    private Long id;

    private String contacts;

    private String telephone;

    /**
     * 1、添加 2、更新 3、删除
     */
    @NotNull
    private Integer action;
    /**
     * 设置当前地址为默认地址 1:是 0:否
     */
    @NotNull(message = "是否默认")
    private Integer ifDefault;
}
