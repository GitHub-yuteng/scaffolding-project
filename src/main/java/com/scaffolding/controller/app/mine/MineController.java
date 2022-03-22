package com.scaffolding.controller.app.mine;

import com.alibaba.fastjson.JSON;
import com.whhim.hxh.auth.Authentication;
import com.whhim.hxh.auth.UserInfo;
import com.whhim.hxh.constant.GlobalConstant;
import com.whhim.hxh.constant.path.GlobalPathConstant;
import com.whhim.hxh.controller.app.mine.req.address.ReceivedAddressReq;
import com.whhim.hxh.controller.order.vo.detail.ReceivedAddressVO;
import com.whhim.hxh.exception.AppException;
import com.whhim.hxh.global.response.ResponseResult;
import com.whhim.hxh.pojo.bean.EnumStatusBean;
import com.whhim.hxh.pojo.req.EmptyReq;
import com.whhim.hxh.pojo.req.StringReq;
import com.whhim.hxh.service.app.mine.MineInfoContext;
import com.whhim.hxh.service.app.mine.vo.MineInfoVO;
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
 * @Desc 个人中心
 */
@RestController
@RequestMapping(value = GlobalPathConstant.INTERCEPT_PATH + GlobalPathConstant.MINE + GlobalPathConstant.VERSION_1)
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
            log.info("MineController#queryMineInfo: Mine, param:{}", stringReq.toString());
            UserInfo userInfo = Authentication.getUserInfo();
            MineInfoVO result = mineInfoContext.queryMineInfo(stringReq, userInfo);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("MineController#queryMineInfo, Mine, param:{}", stringReq.toString(), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

    /**
     * 获取首页/我的对应状态的订单数
     *
     * @return
     */
    @PostMapping(value = "/orderCellCount")
    public ResponseResult<List<EnumStatusBean>> queryOrderCellCount(@RequestBody @Valid StringReq stringReq, HttpServletResponse response) {
        try {
            log.info("OrderInfoController#queryOrderCellCount: 获取对应状态的订单数, param:{}", JSON.toJSONString(stringReq));
            UserInfo userInfo = Authentication.getUserInfo();
            List<EnumStatusBean> orderStatusCountVO = mineInfoContext.listOrderCellCount(stringReq, userInfo);
            return ResponseResult.success(orderStatusCountVO);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("OrderInfoController#queryOrderCellCount, 获取对应状态的订单数, param:{}", JSON.toJSONString(stringReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }


    /**
     * 收货地址
     *
     * @return
     */
    @PostMapping(value = "/receivedAddress")
    public ResponseResult<List<ReceivedAddressVO>> receivedAddress(@RequestBody @Valid EmptyReq emptyReq) {
        try {
            log.info("OrderInfoController#receivedAddress: 收货地址, param:{}", JSON.toJSONString(emptyReq));
            UserInfo userInfo = Authentication.getUserInfo();
            List<ReceivedAddressVO> result = mineInfoContext.receivedAddress(emptyReq, userInfo);
            return ResponseResult.success(result);
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("OrderInfoController#receivedAddress, 收货地址, param:{}", JSON.toJSONString(emptyReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

    /**
     * 添加/更新/删除 收货地址
     *
     * @return
     */
    @PostMapping(value = "/operate/receivedAddress")
    public ResponseResult<String> operateReceivedAddress(@RequestBody @Valid ReceivedAddressReq receivedAddressReq) {
        try {
            log.info("OrderInfoController#operateReceivedAddress: 添加/更新/删除 收货地址, param:{}", JSON.toJSONString(receivedAddressReq));
            UserInfo userInfo = Authentication.getUserInfo();
            mineInfoContext.operateReceivedAddress(receivedAddressReq, userInfo);
            return ResponseResult.success();
        } catch (AppException e) {
            return ResponseResult.fail(e.getMessage());
        } catch (Exception e) {
            log.error("OrderInfoController#operateReceivedAddress, 添加/更新/删除 收货地址, param:{}", JSON.toJSONString(receivedAddressReq), e);
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

}
