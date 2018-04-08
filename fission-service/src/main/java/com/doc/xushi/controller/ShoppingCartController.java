package com.doc.xushi.controller;

import com.alibaba.fastjson.JSON;
import com.doc.xushi.entity.po.CartPo;
import com.doc.xushi.service.ShoppingCartServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 5000 on 2018/4/6.
 */
@RestController
@RequestMapping("/cart")
public class ShoppingCartController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartController.class);

    @Autowired
    ShoppingCartServiceImpl cartService;

    @RequestMapping("/add")
    public ResponseEntity<String> addGoods2cart(String openUserId, Long goodsId) {
        // TODO: 2018/4/7 user session管理
        Long userId = getUserId(openUserId);

        if (userId == null || goodsId == null) {
            responseParamError();
        }

        CartPo cart = new CartPo();
        cart.setAmount(1);
        cart.setGoodsId(goodsId);
        cart.setUserId(userId);
        try {
            LOGGER.info(" add cart,user:{},goods:{}", userId, goodsId);
            cartService.add2MyCart(cart);
            return responseOK();
        } catch (Exception e) {
            LOGGER.error("addGoods2cart ERROR ,user:{},goods:{}", userId, goodsId, e);
            return responseError();
        }
    }

    @RequestMapping("/my")
    public ResponseEntity<String> shoppingCartInfo(Long userId) {
        if (userId == null) {
            return responseParamError();
        }
        try {
            return responseOK(cartService.getMyCartList(userId));
        } catch (Exception e) {
            LOGGER.error("get my cart error,user:{}", userId, e);
            return responseError();
        }
    }

    @RequestMapping("/update")
    public ResponseEntity<String> updateShoppingCart(CartPo cartPo) {

        if (cartPo == null || cartPo.getCartId() == null ) {
            return responseParamError();
        }
        try {
            Long userId = getUserId(null);
            if (userId == null) {
                return responseParamError();
            }
            cartPo.setUserId(userId);

            cartService.updateMyCart(cartPo);
            return responseOK();
        } catch (Exception e) {
            LOGGER.error("get my cart error,user:{}", JSON.toJSONString(cartPo), e);
            return responseError();
        }

    }

}
