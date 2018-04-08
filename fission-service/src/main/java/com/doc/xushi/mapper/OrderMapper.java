package com.doc.xushi.mapper;

import com.doc.xushi.entity.po.GoodsPo;
import com.doc.xushi.entity.po.OrderGoodsPo;
import com.doc.xushi.entity.po.OrderPo;
import com.doc.xushi.entity.vo.PageVo;

import java.awt.*;
import java.util.List;

/**
 * Created by 5000 on 2018/4/6.
 */
public interface OrderMapper {

    OrderPo addOrder(OrderPo order);

    int updateOrder(OrderPo order);

    List<OrderPo> getMyOrderList(PageVo pageVo);

    void insertOrderGoods(List<OrderGoodsPo> orderGoodsList);


    List<OrderGoodsPo> getOrderGoods(List<Long> orderIdList);

}
