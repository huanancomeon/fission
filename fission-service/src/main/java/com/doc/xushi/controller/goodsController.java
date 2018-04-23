package com.doc.xushi.controller;

import com.doc.xushi.annotation.Auth;
import com.doc.xushi.entity.po.GoodsPo;
import com.doc.xushi.entity.vo.PageResultVo;
import com.doc.xushi.service.GoodsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 5000 on 2018/4/1.
 */
@RestController
@RequestMapping("/goods")
public class goodsController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(goodsController.class);

    @Autowired
    GoodsServiceImpl goodsService;

    @RequestMapping("/list")
    public ResponseEntity<String> getGoodsList(int pageIndex, int pageSize) {

        if (pageIndex <= 0 || pageSize <= 0) {
            return responseParamError();
        }
        try {
            PageResultVo<GoodsPo> goodsList = goodsService.getGoodsList(pageIndex, pageSize);
            return responseOK(goodsList);
        } catch (Exception e) {
            LOGGER.error("getGoodsList error", e);
            return responseError();
        }
    }

    @Auth
    @RequestMapping("/info/{goodsId}")
    public ResponseEntity<String> getGoodsById(@PathVariable("goodsId") Long goodsId) {

        if (null == goodsId) {
            return responseParamError();
        }
        try {
            LOGGER.info("getGoodsById goods:{}", goodsId);
            GoodsPo goods = goodsService.getGoods(goodsId);
            return responseOK(goods);
        } catch (Exception e) {
            LOGGER.error("getGoodsById error,goodsID:{}", goodsId, e);
            return responseError();
        }

    }

}
