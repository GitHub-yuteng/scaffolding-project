package com.scaffolding.mapper.order;

import com.whhim.hxh.controller.order.req.OrderListReq;
import com.whhim.hxh.service.order.dto.OrderNoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/28 10:18 上午
 */
@Mapper
public interface ConsumerPurchaseOrderMapper {

    List<OrderNoDTO> queryOrder(@Param("req") OrderListReq orderListReq,
                                @Param("userCode") String userCode,
                                @Param("curRow") Integer curRow,
                                @Param("pageSize") Integer pageSize);

    Integer countOrder(@Param("req") OrderListReq orderListReq,
                       @Param("userCode") String userCode);
}
