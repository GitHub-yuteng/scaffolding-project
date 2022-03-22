package com.scaffolding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whhim.hxh.pojo.entity.HxhOrderDetailEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Vm
 * @since 2022-03-09 14:33:21
 */
@Mapper
public interface HxhOrderDetailMapper extends BaseMapper<HxhOrderDetailEntity> {

    int insertBatch(@Param("list") List<HxhOrderDetailEntity> orderDetailList);

}
