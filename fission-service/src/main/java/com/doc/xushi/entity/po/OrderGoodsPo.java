package com.doc.xushi.entity.po;

import java.io.Serializable;

/**
 * Created by 5000 on 2018/4/7.
 */
public class OrderGoodsPo implements Serializable {

    private static final long serialVersionUID = 380761448262071443L;
    private Long orderId;

    private Long goodsId;

    private Long price;

    private Integer count;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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
