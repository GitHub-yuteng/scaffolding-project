package com.scaffolding.controller.refund.vo;

import com.whhim.hxh.pojo.bean.LabelBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/1 5:53 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RefundLabelVO extends LabelBean {

    private String desc;
}
