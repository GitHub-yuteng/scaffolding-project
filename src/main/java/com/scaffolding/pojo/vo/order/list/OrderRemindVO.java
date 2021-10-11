package com.scaffolding.pojo.vo.order.list;

import com.scaffolding.global.style.SpecialStyle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yt
 * @Date: 2021/06/28/17:26
 * @Description: 订单提示信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRemindVO {

    /**
     * 提示信息
     */
    private String remind;
    private SpecialStyle specialStyle;

}
