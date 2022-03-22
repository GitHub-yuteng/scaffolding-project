package com.scaffolding.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Vm
 * @since 2022-03-03 18:28:43
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("hxh_user")
public class HxhUserEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String openId;

    private String unionId;

    private String userCode;

    private String nickname;

    /**
     * 0:未填写 1:男 2:女
     */
    private Integer gender;

    private LocalDate birthday;

    /**
     * 注册手机号
     */
    private String registerPhone;

    private String signature;

    private Integer userType;

    private String password;

    private String email;

    private String nativePlace;

    private Integer registerClient;

    private String externalAcid;

    private String externalExt;

    private String headUrl;

    /**
     * 1:正常 0:冻结
     */
    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     *  软删除 注销时间
     */
    private LocalDateTime deleteTime;

    /**
     * 1:未删除 0:软删除
     */
    private Integer isDeleted;


}
