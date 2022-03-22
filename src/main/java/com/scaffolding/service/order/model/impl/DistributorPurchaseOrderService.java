package com.scaffolding.service.order.model.impl;

import com.whhim.hxh.mapper.HxhOrderLogisticsMapper;
import com.whhim.hxh.mapper.order.DistributorPurchaseOrderMapper;
import com.whhim.hxh.service.order.model.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/2 10:48 上午
 */
@Service
public class DistributorPurchaseOrderService extends OrderService {

    @Autowired
    private DistributorPurchaseOrderMapper distributorPurchaseOrderMapper;
    @Autowired
    private HxhOrderLogisticsMapper hxhOrderLogisticsMapper;

}
