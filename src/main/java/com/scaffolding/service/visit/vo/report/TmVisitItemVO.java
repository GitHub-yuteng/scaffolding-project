package com.scaffolding.service.visit.vo.report;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/07/11/17:06
 * @Description:
 */
@Data
public class TmVisitItemVO implements Serializable {

    private static final long serialVersionUID = -2116601647374188810L;

    private String marketNo;
    private String marketName;
    private String districtNo;
    private String districtName;

    private String empNo;
    private String empName;
    private String picUrl;

    /**
     * 本人拜访数
     */
    private Integer mineTotal;
    /**
     * 下属拜访数
     */
    private Integer nextTotal;
    /**
     * 经销商拜访数
     */
    private Integer shopTotal;

    private String startTenureDateStr;
    private String endTenureDateStr;


}
