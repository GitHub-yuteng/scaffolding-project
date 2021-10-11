package com.scaffolding.pojo.vo.order.list;

import com.scaffolding.global.style.SpecialStyle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/05/26/20:24
 * @Description: 商品Label
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsLabelVO implements Serializable {

    private static final long serialVersionUID = -2178595151229692312L;

    private Integer labelType;
    private String labelName;
    private SpecialStyle specialStyle;
    private Integer sort;
}
