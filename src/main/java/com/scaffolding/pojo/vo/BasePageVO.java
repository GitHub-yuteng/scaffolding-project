package com.scaffolding.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @author yt
 */
@Data
public class BasePageVO<T> {

    private static final long serialVersionUID = 6509247701000648174L;

    /**
     * 总数.
     */
    protected Integer totalCount;
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

    public Boolean getFinished() {
        if (this.finished != null) {
            return finished;
        }
        finished = (currentPage * pageSize) >= totalCount;
        return finished;
    }

    /**
     * The data.
     */
    protected List<T> data;

}
