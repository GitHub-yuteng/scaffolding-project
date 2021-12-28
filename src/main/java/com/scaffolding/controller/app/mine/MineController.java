package com.scaffolding.controller.app.mine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaffolding.constant.path.GlobalPathConstant;
import com.scaffolding.global.response.ResponseResult;
import com.scaffolding.pojo.req.EmptyReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author whh-yt
 * @Date 2021/12/22
 * @Desc
 */
@RestController
@RequestMapping(value = GlobalPathConstant.INTERCEPT_PATH + GlobalPathConstant.VERSION_1 + GlobalPathConstant.MINE)
public class MineController {

    /**
     *
     * @return
     */
    @PostMapping(value = "/details")
    public ResponseResult<ObjectMapper> queryMineInfo(@RequestBody EmptyReq emptyReq){


        return null;
    }

}
