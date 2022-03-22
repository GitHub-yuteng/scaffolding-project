package com.scaffolding.controller.refund.vo.detail;

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
public class RefundDetailLabelVO extends LabelBean implements Serializable {

    private static final long serialVersionUID = -7557295582664921206L;

    /**
     * 关闭原因
     */
    private String closeReason;

    public RefundDetailLabelVO() {
    }

    public RefundDetailLabelVO(Integer labelType, String labelDesc, String tag, String closeReason) {
        super(labelType, labelDesc);
        this.closeReason = closeReason;
    }
}
