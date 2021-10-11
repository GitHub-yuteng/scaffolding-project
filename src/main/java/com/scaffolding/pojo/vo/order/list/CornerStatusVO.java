package com.scaffolding.pojo.vo.order.list;

import com.scaffolding.global.style.SpecialStyle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/06/10/21:09
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CornerStatusVO implements Serializable {

    private static final long serialVersionUID = 7561207596646415274L;

    private Integer cornerStatusCode;
    private String cornerStatus;
    private SpecialStyle specialStyle;
    private String iconUrl;
}
