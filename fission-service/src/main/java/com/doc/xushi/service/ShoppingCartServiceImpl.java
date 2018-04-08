package com.doc.xushi.service;

import com.alibaba.druid.support.logging.Log;
import com.doc.xushi.entity.po.CartPo;
import com.doc.xushi.mapper.ShoppingCartMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 5000 on 2018/4/7.
 */
@Service("shoppingCartServiceImpl")
public class ShoppingCartServiceImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);

    @Autowired
    ShoppingCartMapper cartMapper;


    public void add2MyCart(CartPo cart) {
        try {
            cartMapper.add2MyCart(cart);
        } catch (Exception e) {
            LOGGER.error("add2MyCart error:{}", cart, e);
        }
    }

    public List<CartPo> getMyCartList(Long userId){
        return cartMapper.getMyCartList(userId);
    }

    public int updateMyCart(CartPo cartPo) {
        return cartMapper.updateMyCart(cartPo);
    }
}
