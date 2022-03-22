package com.scaffolding.controller.refund.vo;

import com.whhim.hxh.pojo.vo.RemindVO;
import com.whhim.hxh.pojo.vo.SortButtonVO;
import lombok.Data;

import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/3 2:11 下午
 */
@Data
public class RefundItemVO {

    private String orderNo;
    private String refundNo;
    private String applyTime;
    private RefundLabelVO refundLabel;
    private List<RefundProductVO> productList;
    private RemindVO remind;
    private List<SortButtonVO> buttonList;

}
