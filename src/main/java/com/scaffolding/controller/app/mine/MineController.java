package com.scaffolding.controller.app.mine;

import com.scaffolding.constant.GlobalConstant;
import com.scaffolding.constant.path.GlobalPathConstant;
import com.scaffolding.exception.AppException;
import com.scaffolding.global.response.ResponseResult;
import com.scaffolding.pojo.req.EmptyReq;
import com.scaffolding.service.app.mine.MineInfoContext;
import com.scaffolding.service.app.mine.vo.MineInfoVO;
import com.scaffolding.util.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yt
 * @Date 2021/12/22
 * @Desc
 */
@RestController
@RequestMapping(value = GlobalPathConstant.INTERCEPT_PATH + GlobalPathConstant.VERSION_1 + GlobalPathConstant.MINE)
public class MineController {

    private final static Logger log = LoggerFactory.getLogger(MineController.class);

    @Autowired
    private MineInfoContext mineInfoContext;

    /**
     * Mine
     *
     * @return
     */
    @PostMapping(value = "/detail")
    public ResponseResult<MineInfoVO> queryMineInfo(@RequestBody EmptyReq emptyReq) {
        try {
            log.info("MineController#queryMineInfo: Mine, param:{}", JacksonUtil.toJsonString(emptyReq));
            MineInfoVO result = mineInfoContext.queryMineInfo(emptyReq);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("MineController#queryMineInfo, Mine, param:{}, Exception:{}", emptyReq.toString(), e.getMessage());
            return ResponseResult.fail(GlobalConstant.ORDER_ERROR_RETURN);
        }
    }

}
