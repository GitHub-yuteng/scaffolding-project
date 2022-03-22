package com.scaffolding.mapper.order;

import com.scaffolding.controller.order.req.OrderListReq;
import com.scaffolding.service.order.dto.OrderNoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/3 1:52 下午
 */
@Mapper
public interface DistributorPurchaseOrderMapper {

    List<OrderNoDTO> queryOrder(@Param("req") OrderListReq orderListReq,
                                @Param("userCode") String userCode,
                                @Param("curRow") Integer curRow,
                                @Param("pageSize") Integer pageSize);

    Integer countOrder(@Param("req") OrderListReq orderListReq,
                       @Param("userCode") String userCode);
}
