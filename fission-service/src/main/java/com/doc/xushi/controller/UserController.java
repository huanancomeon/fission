package com.doc.xushi.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 5000 on 2018/4/30.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private static final String WX_LOGIN_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=474469_h&lang=zh_CN&openid=";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/login")
    public ResponseEntity<String> weCartLogin() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("auth_token", "asdfgh");
        headers.set("Other-Header", "othervalue");
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject parm = new JSONObject();
        parm.put("parm", "1234");

        HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(parm, headers);
        restTemplate.getForObject("", String.class);
        return null;
    }

    @RequestMapping("info")
    public ResponseEntity<String> getUserInfo(String openId) {

        String url = WX_LOGIN_URL + openId;
        String userInfoStr = restTemplate.getForObject(url, String.class);
        LOGGER.info("getUserInfo:{}",userInfoStr);

        return responseOK(userInfoStr);
    }



}
