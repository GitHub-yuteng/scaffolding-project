package com.scaffolding.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Vm
 * @since 2022-03-14 15:49:28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("hxh_user_address")
public class HxhUserAddressEntity {

    /**
     * 用户地址表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户表 id
     */
    private Long userId;

    private String contacts;

    private String telephone;

    private Integer provinceCode;

    private String provinceName;

    private Integer cityCode;

    private String cityName;

    private Integer countyCode;

    private String countyName;

    private String mapPosition;

    private String address;

    /**
     * 1:未删除 0:用户删除
     */
    private Integer isDeleted;

    /**
     * 1:默认选择 0:非默认
     */
    private Integer ifDefault;


}
