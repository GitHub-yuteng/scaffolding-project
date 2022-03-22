package com.scaffolding.mapper.order;

import com.whhim.hxh.controller.order.req.OrderListReq;
import com.whhim.hxh.service.order.dto.OrderNoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 分享推广订单
 * @Author whh-yt
 * @Date 2022/2/25 10:57 上午
 */
@Service
public interface ShareOrderMapper {


    List<OrderNoDTO> queryOrder(@Param("req") OrderListReq orderListReq,
                                @Param("shareId") Long shareId,
                                @Param("curRow") Integer curRow,
                                @Param("pageSize") Integer pageSize);

    Integer countOrder(@Param("req") OrderListReq orderListReq,
                       @Param("shareId") Long shareId);
}

