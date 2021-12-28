package com.scaffolding.controller.extension.visit;

import com.scaffolding.constant.path.GlobalPathConstant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author yt
 * @Date 2021/12/27 6:43 下午
 */

@RestController
@RequestMapping(value = GlobalPathConstant.INTERCEPT_PATH + GlobalPathConstant.VERSION_1 + GlobalPathConstant.VISIT_REPORT_PATH)
public class TmVisitReportController {
}
