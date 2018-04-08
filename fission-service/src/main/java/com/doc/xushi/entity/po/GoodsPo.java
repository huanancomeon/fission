package com.doc.xushi.entity.po;

import java.io.Serializable;

/**
 * Created by 5000 on 2018/4/1.
 */
public class GoodsPo implements Serializable {

    private static final long serialVersionUID = 1793388238520167674L;

    private Long goodsId;

    private String goodsName;

    private Long price;

    private Integer count;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
