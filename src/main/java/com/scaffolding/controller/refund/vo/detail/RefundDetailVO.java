package com.scaffolding.controller.refund.vo.detail;

import com.whhim.hxh.controller.refund.vo.RefundItemVO;
import com.whhim.hxh.pojo.bean.MoneyBean;
import com.whhim.hxh.pojo.bean.ProcessBean;
import lombok.Data;

import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/3 2:22 下午
 */
@Data
public class RefundDetailVO {

    private RefundDetailLabelVO refundDetailLabel;
    private RefundItemVO refundItem;
    private List<RefundBelowVO> refundMsgList;
    private List<ProcessBean> processList;
    private List<MoneyBean> moneyList;
    private List<RefundBelowVO> otherMsgList;
    /**
     * 退款原因
     */
    private List<String> refundReasonList;

}
