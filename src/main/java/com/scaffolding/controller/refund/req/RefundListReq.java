package com.scaffolding.controller.refund.req;

import com.whhim.hxh.pojo.req.BasePageReq;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/3 2:11 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RefundListReq extends BasePageReq implements Serializable {

    private String orderNo;

}
