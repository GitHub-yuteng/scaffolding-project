package com.scaffolding.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 物料spu/sku挂载
 * </p>
 *
 * @author Vm
 * @since 2022-03-10 09:52:11
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("hxh_material_mount")
public class HxhMaterialMountEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String spuCode;

    private String skuCode;

    private Integer valid;

    private LocalDateTime operTime;


}
