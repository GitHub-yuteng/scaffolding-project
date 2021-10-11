package com.scaffolding.pojo.vo.order.detail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/05/26/20:43
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiverVO implements Serializable {

    private static final long serialVersionUID = -7974268243962028577L;

    /**
     * 地址类型描述
     */
    private String addressDesc;
    /**
     * icon
     */
    private String iconUrl;
    /**
     * 收件人名称
     */
    private String receiver;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 地址
     */
    private String address;
}
