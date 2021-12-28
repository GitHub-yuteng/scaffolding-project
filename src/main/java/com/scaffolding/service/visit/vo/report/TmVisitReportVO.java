package com.scaffolding.service.visit.vo.report;

import com.scaffolding.pojo.vo.BasePageVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/07/11/12:57
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TmVisitReportVO extends BasePageVO<TmVisitItemVO> implements Serializable {

    private static final long serialVersionUID = 3265943541512856139L;

    @Valid
    private SelectDateVO selectReportVO;
    /**
     * 下方拜访报表是否展示
     */
    private Boolean showFlag;

}
