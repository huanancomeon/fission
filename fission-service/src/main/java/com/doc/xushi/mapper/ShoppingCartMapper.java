package com.doc.xushi.mapper;

import com.doc.xushi.entity.po.CartPo;

import java.util.List;

/**
 * Created by 5000 on 2018/4/6.
 */
public interface ShoppingCartMapper {

    int add2MyCart(CartPo cart);

    List<CartPo> getMyCartList(Long userId);

    int updateMyCart(CartPo cart);
}
