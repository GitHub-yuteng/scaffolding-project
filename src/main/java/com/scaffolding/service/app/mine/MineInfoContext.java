package com.scaffolding.service.app.mine;

import com.scaffolding.exception.AppException;
import com.scaffolding.pojo.req.StringReq;
import com.scaffolding.service.app.mine.constant.MineConstant;
import com.scaffolding.service.app.mine.enums.RoleClazzEnum;
import com.scaffolding.service.app.mine.role.IMineRoleStrategy;
import com.scaffolding.service.app.mine.vo.MineInfoVO;
import com.scaffolding.util.JacksonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yt
 * @Date: 2021/06/03/8:03
 * @Description:
 */
@Service
public class MineInfoContext {

    private final static Logger log = LoggerFactory.getLogger(MineInfoContext.class);

    @Autowired
    private MineRoleFactory mineRoleFactory;

    /**
     * 我的Mine
     *
     * @param stringReq
     * @return
     */
    public MineInfoVO queryMineInfo(StringReq stringReq) {
        if (StringUtils.isBlank(stringReq.getCode())) {
            log.info("MineInfoContext#queryMineInfo, param:{}", JacksonUtil.toJsonString(stringReq));
            throw new AppException(MineConstant.CODE_IS_ERROR);
        }
        RoleClazzEnum roleClazzEnum = RoleClazzEnum.getEnumByType(stringReq.getCode());
        assert roleClazzEnum != null;
        IMineRoleStrategy mineRoleStrategy = mineRoleFactory.getMineRoleStrategy(roleClazzEnum.getTypeName());
        return mineRoleStrategy.queryMineInfo();
    }
}
