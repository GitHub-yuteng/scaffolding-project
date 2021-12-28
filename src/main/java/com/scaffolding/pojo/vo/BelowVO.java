package com.scaffolding.pojo.vo;

import com.scaffolding.global.style.SpecialStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/04/29/13:49
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BelowVO implements Serializable {

    private static final long serialVersionUID = -53042655554134163L;

    private Integer belowKey;
    private String belowName;
    private String belowValve;
    private List<String> urls;
    /**
     * 特殊处理(大/小 或者其他需求预留)
     */
    private SpecialStyle specialStyle;
    /**
     * 排序
     */
    private Integer sort;

    private String action;

}
