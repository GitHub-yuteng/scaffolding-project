package com.scaffolding.service.visit.dto;

import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * @Author: yt
 * @Date: 2021/07/11/16:28
 * @Description:
 */
@Data
public class VisitParamDTO {

    private Map<String, Date> dateMap;
    private Integer startYear;
    private Integer startMonth;
    private Integer endYear;
    private Integer endMonth;

    /**
     * 角色任期时间
     */
    private Map<String, Date> termDateMap;
    private Integer termStartYear;
    private Integer termStartMonth;
    private Integer termEndYear;
    private Integer termEndMonth;

    private String marketName;
    private String districtNo;

}
