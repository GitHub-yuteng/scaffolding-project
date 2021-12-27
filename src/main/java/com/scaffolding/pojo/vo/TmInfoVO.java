package com.scaffolding.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/05/31/19:40
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TmInfoVO implements Serializable {

    private static final long serialVersionUID = 868809772565084371L;
    /**
     * 终端信息
     */
    private String tmNo;
    /**
     * 店铺名称
     */
    private String tmName;
    /**
     * 终端联系人姓名
     */
    private String connector;
    private String phone;
    /**
     * 地址
     */
    private String address;
    private String picPath;
    /**
     * 5000w代码
     */
    private String scCode;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;

}
