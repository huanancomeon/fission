package com.doc.xushi.controller;

import com.doc.xushi.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 5000 on 2018/4/7.
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Autowired
    OrderServiceImpl orderService;


    @RequestMapping("/create")
    public ResponseEntity<String> createOrder() {
        return responseOK();
    }

    @RequestMapping("/pay")
    public void payOrder() {

    }

    @RequestMapping("/list")
    public ResponseEntity<String> orderList(String openUserId) {
        return responseOK();
    }

    @RequestMapping("/info}")
    public ResponseEntity<String> orderInfo(String openUserId, Long orderId) {
        return responseOK();
    }
}
