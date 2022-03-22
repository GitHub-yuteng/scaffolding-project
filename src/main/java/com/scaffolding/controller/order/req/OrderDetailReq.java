package com.scaffolding.controller.order.req;

import com.whhim.hxh.controller.order.vo.OrderProductVO;
import com.whhim.hxh.pojo.bean.AddressBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/2/24 3:29 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDetailReq extends OrderNoReq implements Serializable {

    private Long addressId;
    @Valid
    private AddressBean address;

    private List<OrderProductVO> productList;


}
