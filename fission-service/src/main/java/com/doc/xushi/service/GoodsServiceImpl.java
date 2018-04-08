package com.doc.xushi.service;

import com.doc.xushi.entity.po.GoodsPo;
import com.doc.xushi.entity.vo.PageResultVo;
import com.doc.xushi.entity.vo.PageVo;
import com.doc.xushi.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 5000 on 2018/4/1.
 */
@Service("goodsService")
public class GoodsServiceImpl {


    @Autowired
    GoodsMapper goodsMapper;

    public GoodsPo getGoods(Long goodsId) {

        return goodsMapper.getGoodsById(goodsId);

    }


    public PageResultVo getGoodsList(int pages, int pageSize) {
        PageVo pageVo = new PageVo();
        pageVo.setPageSize(pageSize);
        pageVo.setIndex((pages - 1) * pageSize);
        PageResultVo resultVo = new PageResultVo();

        int count = goodsMapper.getGoodsCount();
        List<GoodsPo> goodsList = goodsMapper.getGoodsList(pageVo);
        resultVo.setCount(count);
        resultVo.setObjList(goodsList);

        return resultVo;

    }

    public int updateGoods(GoodsPo goodsDO) {

       return goodsMapper.updateGoods(goodsDO);

    }
}
