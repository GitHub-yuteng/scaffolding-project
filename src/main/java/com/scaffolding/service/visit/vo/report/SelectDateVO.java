package com.scaffolding.service.visit.vo.report;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author whh-yt
 * @Date 2021/9/6
 * @Desc
 */
@Data
public class SelectDateVO implements Serializable {

    private static final long serialVersionUID = 7474627921264969385L;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;
    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDate;
    /**
     * 时间类别(1:日,2:周,3:月)
     */
    private Integer dateType;
    /**
     * 年份
     */
    private Integer year;
    /**
     * 选择的日期数(第几周或者第几月)
     */
    private Integer pickX;

}
