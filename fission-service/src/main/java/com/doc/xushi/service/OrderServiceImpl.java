package com.doc.xushi.service;

import com.alibaba.fastjson.JSON;
import com.doc.xushi.entity.po.GoodsPo;
import com.doc.xushi.entity.po.OrderGoodsPo;
import com.doc.xushi.entity.po.OrderPo;
import com.doc.xushi.entity.vo.PageVo;
import com.doc.xushi.mapper.GoodsMapper;
import com.doc.xushi.mapper.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 5000 on 2018/4/7.
 */
@Service("orderServiceImpl")
public class OrderServiceImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    GoodsMapper goodsMapper;

    public void addOrder(OrderPo orderPo) throws Exception {
        if (orderPo == null || CollectionUtils.isEmpty(orderPo.getGoodsList())) {
            LOGGER.error("订单参数异常：订单信息：{}", JSON.toJSONString(orderPo));
            throw new Exception("订单参数异常");
        }
        List<Long> goodsList = new ArrayList<>();
        Map<Long, Integer> goodsCountMap = new HashMap<>();
        orderPo.getGoodsList().stream().filter(t -> t.getGoodsId() != null && t.getCount() != null)
                .forEach(t -> {
                    goodsList.add(t.getGoodsId());
                    goodsCountMap.put(t.getGoodsId(), t.getCount());
                });

        if (CollectionUtils.isEmpty(goodsList)) {
            LOGGER.error("订单参数异常：订单信息：{}", JSON.toJSONString(orderPo));
            throw new Exception("订单参数异常");
        }
        //获取订单中商品信息，以数据库为准
        List<GoodsPo> orderGoodsList = goodsMapper.getGoodsByIdList(goodsList);

        //计算订单总价
        Long totalPrice = orderGoodsList.stream().map(g -> goodsCountMap.get(g.getGoodsId()) * g.getPrice())
                .reduce(0L, (a, b) -> a + b);
        if (totalPrice == null || totalPrice <= 0L) {
            LOGGER.error("订单参数异常：订单信息：{}", JSON.toJSONString(orderPo));
            throw new Exception("订单参数异常");
        }
        orderPo.setMoney(totalPrice);

        orderMapper.addOrder(orderPo);
        Long orderId = orderPo.getOrderId();
        if (orderId == null) {
            LOGGER.error("创建订单异常：订单信息：{}", JSON.toJSONString(orderPo));
            throw new Exception("创建订单异常");
        }

        //插入订单商品关系
        List<OrderGoodsPo> ogList = orderGoodsList.stream().map(g -> {
            OrderGoodsPo og = new OrderGoodsPo();
            og.setGoodsId(g.getGoodsId());
            og.setCount(goodsCountMap.get(g.getGoodsId()));
            og.setOrderId(orderId);
            og.setPrice(g.getPrice());
            return og;
        }).collect(Collectors.toList());
        orderMapper.insertOrderGoods(ogList);
    }

    public void updateOrderInfo(OrderPo orderPo) throws Exception {
        int cnt = orderMapper.updateOrder(orderPo);
        if (cnt < 1) {
            LOGGER.error("更新订单信息失败 ,order:{}", JSON.toJSONString(orderPo));
            throw new Exception("更新订单信息失败");
        }
    }

    public List<OrderPo> getMyOrderList(PageVo pageVo) throws Exception {

        List<OrderPo> orders = orderMapper.getMyOrderList(pageVo);
        List<Long> orderIds = orders.stream().map(o -> o.getOrderId()).collect(Collectors.toList());
        List<OrderGoodsPo> goodsList = orderMapper.getOrderGoods(orderIds);
        if (CollectionUtils.isEmpty(orderIds)||CollectionUtils.isEmpty(goodsList)) {
            return orders;
        }
        //匹配各个订单下的商品
        orders.stream().forEach(o->
            o.setGoodsList(goodsList.stream().filter(g -> g.getOrderId().equals(o.getOrderId()))
                    .collect(Collectors.toList())));
        return orders;

    }
}
