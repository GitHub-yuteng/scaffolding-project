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
 * 用户表
 * </p>
 *
 * @author Vm
 * @since 2021-12-27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("uc_user")
public class UcUserEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户内部id
     */
    private Long userId;

    /**
     * 外部账号标识
     */
    private String externalAccountId;

    /**
     * 外部扩展字段
     */
    private String externalAccountExt;

    /**
     * 1:C端用户 2:B端用户
     */
    private Integer userType;

    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别;0:未知、1:男、2:女
     */
    private Integer gender;

    /**
     * 生日
     */
    private LocalDate birthday;

    private String signature;

    /**
     * 用户头像url link
     */
    private Long headPictureLink;

    /**
     * 用户注册平台
1：ios
2：Android
3：小程序
4：H5
6:邮箱
     */
    private Integer registerClient;

    /**
     * 外部账号类型
     */
    private String registerPhone;

    private String email;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 0：否；1：是
     */
    private Integer internal;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 注销时间
     */
    private LocalDateTime deleteTime;

    /**
     * 1:正常 2:冻结
     */
    private Integer status;


}
