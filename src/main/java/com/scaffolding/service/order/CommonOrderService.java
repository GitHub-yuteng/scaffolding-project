package com.scaffolding.service.order;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.whhim.hxh.exception.AppException;
import com.whhim.hxh.mapper.HxhOrderDetailMapper;
import com.whhim.hxh.mapper.HxhOrderMapper;
import com.whhim.hxh.pojo.entity.HxhOrderDetailEntity;
import com.whhim.hxh.pojo.entity.HxhOrderEntity;
import com.whhim.hxh.service.order.constant.OrderMessageConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/25 10:16 上午
 */
@Component
public class CommonOrderService {

    @Autowired
    private HxhOrderMapper hxhOrderMapper;
    @Autowired
    private HxhOrderDetailMapper hxhOrderDetailMapper;

    /**
     * 根据订单号获取订单主表信息
     *
     * @param orderNo
     * @return
     */
    public HxhOrderEntity getOrder(String orderNo) {
        if (StringUtils.isBlank(orderNo)) {
            throw new AppException(OrderMessageConstant.ORDER_NO_IS_NULL);
        }
        return hxhOrderMapper.selectOne(new QueryWrapper<HxhOrderEntity>().lambda().eq(HxhOrderEntity::getOrderNo, orderNo));
    }


    /**
     * 根据订单号List获取订单主表信息
     *
     * @param orderNoList
     * @return
     */
    public List<HxhOrderEntity> listOrder(List<String> orderNoList) {
        if (CollectionUtils.isEmpty(orderNoList)) {
            throw new AppException(OrderMessageConstant.ORDER_NO_IS_NULL);
        }
        return hxhOrderMapper.selectList(new QueryWrapper<HxhOrderEntity>().lambda().in(HxhOrderEntity::getOrderNo, orderNoList));
    }

    /**
     * 根据订单号获取订单系表信息
     *
     * @param orderNo
     * @return
     */
    public List<HxhOrderDetailEntity> getOrderDetail(String orderNo) {
        if (StringUtils.isBlank(orderNo)) {
            throw new AppException(OrderMessageConstant.ORDER_NO_IS_NULL);
        }
        return hxhOrderDetailMapper.selectList(new QueryWrapper<HxhOrderDetailEntity>().lambda().eq(HxhOrderDetailEntity::getOrderNo, orderNo));
    }

    /**
     * 根据订单号 行项目 获取订单系表信息
     *
     * @param orderNo
     * @return
     */
    public HxhOrderDetailEntity getOrderDetail(String orderNo, Integer itemNo) {
        if (StringUtils.isBlank(orderNo)) {
            throw new AppException(OrderMessageConstant.ORDER_NO_IS_NULL);
        }
        if (Objects.isNull(itemNo)) {
            return null;
        }
        return hxhOrderDetailMapper.selectOne(new QueryWrapper<HxhOrderDetailEntity>().lambda()
                .eq(HxhOrderDetailEntity::getOrderNo, orderNo).eq(HxhOrderDetailEntity::getItemNo, itemNo));
    }

    public List<HxhOrderDetailEntity> getOrderDetailList(String orderNo, List<Integer> itemNoList) {
        if (StringUtils.isBlank(orderNo)) {
            throw new AppException(OrderMessageConstant.ORDER_NO_IS_NULL);
        }
        if (CollectionUtils.isEmpty(itemNoList)) {
            throw new AppException(OrderMessageConstant.ORDERD_ITEM_NO_IS_NULL);
        }
        return hxhOrderDetailMapper.selectList(new QueryWrapper<HxhOrderDetailEntity>().lambda()
                .eq(HxhOrderDetailEntity::getOrderNo, orderNo)
                .in(HxhOrderDetailEntity::getItemNo, itemNoList)
        );
    }

    /**
     * 获取多个订单的订单系表
     *
     * @param orderNoList
     * @return
     */
    public List<HxhOrderDetailEntity> listOrderDetail(List<String> orderNoList) {
        if (CollectionUtils.isEmpty(orderNoList)) {
            throw new AppException(OrderMessageConstant.ORDER_NO_IS_NULL);
        }
        return hxhOrderDetailMapper.selectList(new QueryWrapper<HxhOrderDetailEntity>().lambda().in(HxhOrderDetailEntity::getOrderNo, orderNoList));
    }

}
