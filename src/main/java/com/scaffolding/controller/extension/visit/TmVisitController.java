package com.scaffolding.controller.extension.visit;

import com.scaffolding.constant.path.GlobalPathConstant;
import com.scaffolding.service.visit.TmVisitContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yt
 * @Date: 2021/07/01/10:21
 * @Description: 终端拜访
 */
@Slf4j
@RestController
@RequestMapping(value = GlobalPathConstant.INTERCEPT_PATH + GlobalPathConstant.VERSION_1 + GlobalPathConstant.VISIT_PATH)
public class TmVisitController {

    @Autowired
    private TmVisitContext tmVisitContext;


}
