package com.scaffolding.controller.app.mine;

import com.scaffolding.auth.Authentication;
import com.scaffolding.auth.UserInfo;
import com.scaffolding.constant.GlobalConstant;
import com.scaffolding.constant.path.GlobalPathConstant;
import com.scaffolding.exception.AppException;
import com.scaffolding.global.response.ResponseResult;
import com.scaffolding.pojo.req.StringReq;
import com.scaffolding.pojo.vo.StatusCountVO;
import com.scaffolding.service.app.mine.MineInfoContext;
import com.scaffolding.service.app.mine.vo.MineInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

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
    public ResponseResult<MineInfoVO> queryMineInfo(@RequestBody StringReq stringReq) {
        try {
            log.info("MineController#queryMineInfo: Mine, param:{}",stringReq.toString());
            UserInfo userInfo = Authentication.getUserInfo();
            MineInfoVO result = mineInfoContext.queryMineInfo(stringReq,userInfo);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("MineController#queryMineInfo, Mine, param:{}, Exception:{}", stringReq.toString(), e.getMessage());
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

    /**
     * 获取首页/我的对应状态的订单数
     *
     * @return
     */
    @PostMapping(value = "/orderCellCount")
    public ResponseResult<List<StatusCountVO>> queryOrderCellCount(@RequestBody @Valid StringReq stringReq, HttpServletResponse response) {
        try {
            log.info("OrderInfoController#queryOrderCellCount: 获取对应状态的订单数, param:{}");
            UserInfo userInfo = Authentication.getUserInfo();
            List<StatusCountVO> orderStatusCountVO = mineInfoContext.listOrderCellCount(stringReq, userInfo);
            return ResponseResult.success(orderStatusCountVO);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("OrderInfoController#queryOrderCellCount, 获取对应状态的订单数, param:{}, Exception:{}", e.getMessage());
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

}
