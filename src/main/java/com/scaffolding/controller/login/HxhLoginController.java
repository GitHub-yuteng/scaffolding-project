package com.scaffolding.controller.login;

import com.whhim.hxh.constant.GlobalConstant;
import com.whhim.hxh.constant.path.GlobalPathConstant;
import com.whhim.hxh.controller.login.req.LoginReq;
import com.whhim.hxh.controller.login.vo.AppLoginVO;
import com.whhim.hxh.global.response.ResponseResult;
import com.whhim.hxh.service.login.HxhLoginContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/21 7:16 下午
 */
@Slf4j
@RestController
@RequestMapping(value = GlobalPathConstant.OPEN_PATH + GlobalPathConstant.LOGIN + GlobalPathConstant.VERSION_1)
public class HxhLoginController {

    @Autowired
    private HxhLoginContext hxhLoginContext;

    @PostMapping(value = "/appLogin")
    public ResponseResult<AppLoginVO> login(@Valid @RequestBody LoginReq loginReq, HttpServletRequest request) {
        try {
            AppLoginVO result = hxhLoginContext.login(loginReq);
            return ResponseResult.success(result);
        } catch (Exception e) {
            return ResponseResult.fail(GlobalConstant.NETWORK_ERROR);
        }
    }

}
