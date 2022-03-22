package com.scaffolding.pojo.vo;

import com.whhim.hxh.global.style.SpecialStyle;
import lombok.Data;

/**
 * @Author: yt
 * @Date: 2021/06/28/17:26
 * @Description: 订单提示信息
 */
@Data
public class RemindVO {

    /**
     * 提示信息
     */
    private String remind;
    private SpecialStyle specialStyle;
}
