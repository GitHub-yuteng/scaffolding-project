package com.scaffolding.service.app.mine;

import com.scaffolding.pojo.req.EmptyReq;
import com.scaffolding.service.app.mine.vo.MineInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yt
 * @Date: 2021/06/03/8:03
 * @Description:
 */
@Service
public class MineInfoContext {

    @Autowired
    private RoleFactory roleFactory;

    /**
     * 我的Mine
     * @param emptyReq
     * @return
     */
    public MineInfoVO queryMineInfo(EmptyReq emptyReq) {
        MineInfoVO mineInfoVO = new MineInfoVO();
        return mineInfoVO;
    }
}
