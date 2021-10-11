package com.scaffolding.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @author whh-yt
 */
@Data
public class BasePageVO<T> {

    private static final long serialVersionUID = 6509247701000648174L;

    /**
     * 总数.
     */
    protected Long totalCount;
    /**
     * 当前页码.
     */
    protected Integer currentPage;
    /**
     * 每页记录数.
     */
    protected Integer pageSize;
    /**
     * 是否是最后一页
     */
    protected Boolean finished;
    /**
     * The data.
     */
    protected List<T> data;

}
