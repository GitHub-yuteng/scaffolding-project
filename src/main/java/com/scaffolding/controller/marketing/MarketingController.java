package com.scaffolding.controller.marketing;

import com.whhim.hxh.constant.path.GlobalPathConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 营销接口 预留计算 优惠券+活动
 * @Author whh-yt
 * @Date 2022/3/14 6:22 下午
 */
@Slf4j
@RestController
@RequestMapping(value = GlobalPathConstant.INTERCEPT_PATH + GlobalPathConstant.MARKETING_PATH + GlobalPathConstant.VERSION_1)
public class MarketingController {
}
