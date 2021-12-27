package com.scaffolding.service.visit.vo;


import com.scaffolding.pojo.vo.LabelVO;
import com.scaffolding.pojo.vo.TmInfoVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Objects;

/**
 * @Author: yt
 * @Date: 2021/07/02/11:10
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TmVisitVO extends VisitVO {

    private static final long serialVersionUID = 4387542452365608333L;

    /**
     * 终端信息
     */
    private TmInfoVO tmInfo;

    /**
     * 标签
     */
    private List<LabelVO> visitLabel;
    /**
     * 距离
     */
    private Integer distance;
    /**
     * 距离(带单位)
     */
    private String distanceStr;

    public String getDistanceStr() {
        if (Objects.isNull(this.distance)) {
            return "0米";
        }
        return this.distance + "米";
    }
}
