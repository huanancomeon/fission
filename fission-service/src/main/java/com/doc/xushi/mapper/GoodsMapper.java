package com.doc.xushi.mapper;

import com.doc.xushi.entity.po.GoodsPo;
import com.doc.xushi.entity.vo.PageVo;

import java.util.List;

/**
 * Created by 5000 on 2018/4/1.
 */

public interface GoodsMapper {

    List<GoodsPo> getGoodsList(PageVo pageVo);


    List<GoodsPo> getGoodsByIdList(List<Long> goodsIds);

    int getGoodsCount();

    GoodsPo getGoodsById(Long goodsId);

    int updateGoods(GoodsPo goods);
}
