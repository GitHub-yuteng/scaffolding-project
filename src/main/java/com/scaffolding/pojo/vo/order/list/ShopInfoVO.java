package com.scaffolding.pojo.vo.order.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yt
 * @Date: 2021/05/31/19:38
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopInfoVO implements Serializable {

    private static final long serialVersionUID = -4598700701415197774L;
    /**
     * 店铺/经销商/快销网
     */
    private String shopId;
    private String shopName;
    private String picPath;
}
