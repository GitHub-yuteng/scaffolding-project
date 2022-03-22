package com.scaffolding.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/05/26/20:43
 * @Description:
 */
@Data
public class ReceiverVO implements Serializable {

    private static final long serialVersionUID = -7974268243962028577L;
    /**
     * 收件人名称
     */
    private String receiver;
    /**
     * 联系电话
     */
    private String phone;

    private String address;

}
