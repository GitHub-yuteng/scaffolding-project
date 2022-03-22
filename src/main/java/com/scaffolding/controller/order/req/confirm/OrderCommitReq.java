package com.scaffolding.controller.order.req.confirm;

import com.whhim.hxh.controller.order.vo.confirm.StoreProductVO;
import com.whhim.hxh.controller.order.vo.detail.ReceivedAddressVO;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: TODO
 * @Author whh-yt
 * @Date 2022/3/8 3:52 下午
 */
@Data
public class OrderCommitReq implements Serializable {

    /**
     * 确认方式 1:直接下单 2:购物车下单
     */
    private Integer confirmWay;
    @Valid
    @NotNull(message = "请选择收货地")
    private ReceivedAddressVO receivedAddress;
    @Valid
    @NotEmpty(message = "商品为空")
    private List<StoreProductVO> storeProductList;
    /**
     * 买家备注
     */
    @Length(max = 32)
    private String note;

    private String payPattern;

    private Long shareId;
}
