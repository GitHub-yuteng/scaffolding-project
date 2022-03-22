package com.scaffolding.controller.pay.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/15 7:29 下午
 */
@Data
public class PayOrderReq implements Serializable {

    /**
     * 付款方式
     */
    private String channelCode;
    @NotEmpty
    private List<String> orderNoList;
}
