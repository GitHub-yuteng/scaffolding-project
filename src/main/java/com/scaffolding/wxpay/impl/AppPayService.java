package com.scaffolding.wxpay.impl;

import com.scaffolding.wxpay.IHaXiaoHuiPayStrategy;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/17 2:30 下午
 */
@Service
public class AppPayService implements IHaXiaoHuiPayStrategy {

    private final static String URL = "https://api.mch.weixin.qq.com/v3/pay/partner/transactions/app";



}
