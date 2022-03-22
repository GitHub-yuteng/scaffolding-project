package com.scaffolding.service.order.dto;

import com.whhim.hxh.controller.order.req.confirm.OrderCommitReq;
import com.whhim.hxh.pojo.entity.HxhMaterialEntity;
import com.whhim.hxh.pojo.entity.HxhOrderDetailEntity;
import com.whhim.hxh.pojo.entity.HxhOrderEntity;
import lombok.Data;

import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/28 9:27 上午
 */
@Data
public class OrderParamDTO {

    /**
     * 单个订单
     */
    private HxhOrderEntity orderInfo;
    /**
     * 单个商品
     */
    private HxhOrderDetailEntity orderDetail;

    /**
     * 多个订单
     */
    private List<HxhOrderEntity> orderList;
    private List<HxhOrderDetailEntity> orderDetailList;
    private List<HxhMaterialEntity> materialList;

    /**
     * 提交订单请求参数
     */
    private OrderCommitReq commitReq;

}
