package com.scaffolding.pojo.vo.order.list;

import com.scaffolding.global.style.SpecialStyle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/06/23/16:11
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLableVO implements Serializable {
    
    private Integer labelType;
    private String  labelName;
    private SpecialStyle specialStyle;
    private Integer sort;
}
