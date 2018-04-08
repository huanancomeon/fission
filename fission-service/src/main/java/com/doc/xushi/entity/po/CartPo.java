package com.doc.xushi.entity.po;

import java.io.Serializable;

/**
 * Created by 5000 on 2018/4/6.
 */
public class CartPo implements Serializable {
    private static final long serialVersionUID = -3095901626333905071L;

    private Long cartId;

    private Long userId;

    private Long goodsId;

    private Integer amount;

    private Integer status;


    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
