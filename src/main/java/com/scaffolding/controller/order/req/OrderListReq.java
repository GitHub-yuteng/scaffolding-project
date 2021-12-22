package com.scaffolding.controller.order.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: yt
 * @Date: 2021/06/03/8:12
 * @Description:
 */
@Data
public class OrderListReq extends OrderModelReq implements Serializable {

    private static final long serialVersionUID = -3295802549570836409L;

    /**
     * 当前页
     */
    private Integer currentPage;

    public Integer getCurrentPage() {
        if (this.currentPage == null) {
            return 1;
        }
        return currentPage;
    }

    /**
     * 每页大小
     */
    private Integer pageSize;

    public Integer getPageSize() {
        if (this.pageSize == null) {
            return 10;
        }
        return pageSize;
    }
    /**
     * 搜索关键词
     */
    private String searchKey;
    /**
     * 订单状态
     */
    @NotNull
    private Integer statusType;
    /**
     * 下单来源
     */
    private List<Integer> sourceTypeList;
    /**
     * 本地店铺/厂家直营/普通订单
     */
    private Integer queryModel;

}