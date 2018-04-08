package com.doc.xushi;

import com.doc.xushi.entity.po.GoodsPo;
import com.doc.xushi.service.GoodsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 5000 on 2018/4/1.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class BaseTest {

    @Autowired
    GoodsServiceImpl goodsService;


    @Test
    public void test()
    {
        GoodsPo goods = goodsService.getGoods(1L);
        System.err.println(goods.getGoodsId());


        goods.setGoodsName("哈哈1");
        goodsService.updateGoods(goods);
        goods = goodsService.getGoods(1L);
        System.err.println(goods.getGoodsId());
    }
}
