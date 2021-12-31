package com.scaffolding.service.app.mine;

import com.scaffolding.exception.AppException;
import com.scaffolding.pojo.req.StringReq;
import com.scaffolding.service.app.mine.constant.MineConstant;
import com.scaffolding.service.app.mine.enums.RoleClazzEnum;
import com.scaffolding.service.app.mine.vo.MineInfoVO;
import com.scaffolding.service.order.model.IOrderModelStrategy;
import org.apache.commons.lang3.StringUtils;
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
     * @param stringReq
     * @return
     */
    public MineInfoVO queryMineInfo(StringReq stringReq) {
        if(StringUtils.isBlank(stringReq.getCode())){
            throw new AppException(MineConstant.CODE_IS_ERROR);
        }
        RoleClazzEnum roleClazzEnum = RoleClazzEnum.getEnumByType(stringReq.getCode());
        assert roleClazzEnum != null;
        IOrderModelStrategy orderModelStrategy = roleFactory.getOrderModelStrategy(roleClazzEnum.getTypeName());
        return orderModelStrategy.queryMineInfo();
    }
}
