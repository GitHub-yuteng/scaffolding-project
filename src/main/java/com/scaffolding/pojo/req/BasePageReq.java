package com.scaffolding.pojo.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @description
 * @author: chen zixin
 * @create: 2021/8/25
 */
@Data
public class BasePageReq implements Serializable {
    private static final long serialVersionUID = -167656756275656670L;

    /**
     * 当前页码.
     */
    protected Integer currentPage = 1;

    public Integer getCurrentPage() {
        if (this.currentPage == null || this.currentPage == 0) {
            return 1;
        }
        return currentPage;
    }

    /**
     * 每页记录数.
     */
    protected Integer pageSize = 10;

    public Integer getPageSize() {
        if (this.pageSize == null) {
            return 10;
        }
        return pageSize;
    }
}
