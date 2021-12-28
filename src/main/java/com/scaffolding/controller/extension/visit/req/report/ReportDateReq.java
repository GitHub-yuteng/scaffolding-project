package com.scaffolding.controller.extension.visit.req.report;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.scaffolding.pojo.req.BasePageReq;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author whh-yt
 * @Date 2021/9/6
 * @Desc
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReportDateReq extends BasePageReq implements Serializable {

    private static final long serialVersionUID = 9110141297046472514L;

    /**
     * 时间类别(1:日,2:周,3:月)
     */
    @NotNull(message = "日期类别不能为空")
    private Integer dateType;
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
     * 前后标签(-1:代表前，1:代表后)
     */
    private Integer stepTarget;
    /**
     * 年份
     */
    private Integer year;
    /**
     * 选择的日期数(第几周或者第几月)
     */
    private Integer pick;

    public Integer getPick() {
        return this.pick == null ? 1 : this.pick;
    }
}
