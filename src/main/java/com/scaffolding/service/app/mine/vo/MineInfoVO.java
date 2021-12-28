package com.scaffolding.service.app.mine.vo;

import com.scaffolding.auth.UserInfo;
import com.scaffolding.pojo.vo.BelowVO;
import com.scaffolding.pojo.vo.StatusCountVO;
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

    private UserInfo userInfo;
    private RoleSelectVO roleSelectVO;
    private List<StatusCountVO> orderCells;
    private CouponsVO couponsVO;
    private PointVO pointVO;
    private List<BelowVO> belows;
}
