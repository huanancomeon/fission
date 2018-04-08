package com.doc.xushi.entity.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 5000 on 2018/4/1.
 */
public class PageResultVo<T> implements Serializable {
    private static final long serialVersionUID = 3330809269707099179L;

    private int count;

    private List<T> objList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getObjList() {
        return objList;
    }

    public void setObjList(List<T> objList) {
        this.objList = objList;
    }
}
