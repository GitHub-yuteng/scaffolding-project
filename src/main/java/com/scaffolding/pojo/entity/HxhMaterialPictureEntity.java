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
 * 
 * </p>
 *
 * @author Vm
 * @since 2022-03-10 09:51:01
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("hxh_material_picture")
public class HxhMaterialPictureEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String skuCode;

    private String pictureUrl;

    /**
     * 1:轮播图 2:详情页长图
     */
    private Integer picType;

    private Integer sort;

    /**
     * 1:有效 0:无效
     */
    private Integer valid;

    private String operBy;

    private LocalDateTime operTime;


}
