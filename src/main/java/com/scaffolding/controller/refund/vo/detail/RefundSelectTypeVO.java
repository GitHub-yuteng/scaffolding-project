package com.scaffolding.controller.refund.vo.detail;

import com.whhim.hxh.controller.refund.vo.RefundLabelVO;
import lombok.Data;

import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/7 8:36 上午
 */
@Data
public class RefundSelectTypeVO {

    private List<RefundLabelVO> refundLabelList;

    /**
     * true 有售后历史
     */
    private Boolean history;
}
