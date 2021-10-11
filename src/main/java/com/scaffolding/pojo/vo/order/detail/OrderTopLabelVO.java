package com.scaffolding.pojo.vo.order.detail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/05/26/20:32
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderTopLabelVO implements Serializable {

    private static final long serialVersionUID = -7557295582664921206L;

    /**
     * 订单详情状态码
     */
    private Integer statusType;
    /**
     * 订单详情状态
     */
    private String statusName;
    /**
     * 角标
     */
    private String tag;
    /**
     * iconUrl
     */
    private String iconUrl;
    /**
     * 状态对应时间
     */
    private String showDate;
    /**
     * 关闭原因
     */
    private String closeReason;
    /**
     * 预留字段
     */
    private String prepare;
}
