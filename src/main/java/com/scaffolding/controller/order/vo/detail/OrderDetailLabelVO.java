package com.scaffolding.controller.order.vo.detail;

import com.whhim.hxh.pojo.bean.LabelBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/05/26/20:32
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDetailLabelVO extends LabelBean implements Serializable {

    private static final long serialVersionUID = -7557295582664921206L;

    /**
     * 角标
     */
    private String tag;
    /**
     * 关闭原因
     */
    private String closeReason;
    /**
     * 倒计时
     */
    private Long countDownTime;

    public OrderDetailLabelVO() {
    }

    public OrderDetailLabelVO(Integer labelType, String labelName, String tag, String closeReason) {
        super(labelType, labelName);
        this.tag = tag;
        this.closeReason = closeReason;
    }
}
