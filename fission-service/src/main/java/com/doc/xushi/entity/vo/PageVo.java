package com.doc.xushi.entity.vo;

import java.io.Serializable;

/**
 * Created by 5000 on 2018/4/1.
 */
public class PageVo implements Serializable {

    private static final long serialVersionUID = 8279077850699628036L;

    private int index;

    private int pageSize;

    private Long userId;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
