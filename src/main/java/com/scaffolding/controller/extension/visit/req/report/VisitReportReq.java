package com.scaffolding.controller.extension.visit.req.report;

import com.scaffolding.auth.UserInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/07/02/8:21
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class VisitReportReq extends ReportDateReq implements Serializable {

    private static final long serialVersionUID = 7939405053966638608L;

    /**
     * 用户身份对应的唯一代码（业务员-工号 娃哈哈-工号 经销商-SH 终端-T）
     */
    private String roleCode;
    /**
     * 角色对应的枚举值
     */
    private Integer roleSelectCode;
    /**
     * 细分角色
     */
    private String levelClass;

    /**
     * 市场类型(1:销售市场,2:城市开发)
     */
    private Integer marketType;
    /**
     * 市场名称
     */
    private String marketName;
    /**
     * 区域编码
     */
    private String districtNo;
    /**
     * 是否为自己登陆查询  0 上级查询 / 1 自己登陆查询
     */
    private Integer ifSelf;
    @Valid
    private UserInfo userInfo;

}
