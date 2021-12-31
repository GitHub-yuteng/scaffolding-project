package com.scaffolding.service.app.mine.vo;

import com.scaffolding.auth.UserInfo;
import com.scaffolding.pojo.vo.BelowVO;
import com.scaffolding.pojo.vo.CellVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TODO
 * @Author yt
 * @Date 2021/12/28 11:29 上午
 */
@Data
public class MineInfoVO implements Serializable {

    private static final long serialVersionUID = -6904277034804004007L;

    private UserInfo userInfo;
    private RoleSelectVO roleSelectVO;
    private List<CellVO> orderCells;
    private CouponsVO couponsVO;
    private PointVO pointVO;
    private List<BelowVO> belows;
    /**
     * 字典表存：样式，让前端渲染显示不同的样式
     */
    private String style;
}
