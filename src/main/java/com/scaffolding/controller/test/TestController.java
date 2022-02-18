package com.scaffolding.controller.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.scaffolding.aspect.SysLog;
import com.scaffolding.global.bean.PcPlatformBean;
import com.scaffolding.global.response.ResponseResult;
import com.scaffolding.util.JacksonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/18 1:51 下午
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @SysLog
    @RequestMapping(value = "/add")
    public ResponseResult test() throws JsonProcessingException {
        System.out.println("133");
        PcPlatformBean bean = new PcPlatformBean();
        System.out.println(JacksonUtil.toJsonString(bean));
        return ResponseResult.success();
    }

}
