package com.doc.xushi.controller;

import com.alibaba.fastjson.JSON;
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

    private static String app_id = "wx6b138ac2be82f4af";
    private static String SECRET = "6019df3049a24730d5173470a5fa30de";



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

    @RequestMapping("/info")
    public ResponseEntity<String> getUserInfo(String openId) {


        String url = WX_LOGIN_URL + openId;
        String userInfoStr = restTemplate.getForObject(url, String.class);
        LOGGER.info("getUserInfo:{}",userInfoStr);

        return responseOK(userInfoStr);
    }


    @RequestMapping("/authcode")
    public ResponseEntity<String> getAuthCode(String code,String state) {

        LOGGER.info("getAuthCode:{},state{}",code,state);

        String accessUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx6b138ac2be82f4af&secret=6019df3049a24730d5173470a5fa30de&code=";
        accessUrl = accessUrl + code + "&grant_type=authorization_code";
        try {
            String accessInfoStr = restTemplate.getForObject(accessUrl, String.class);

            LOGGER.info("accessInfoStr:{}",accessInfoStr);

            JSONObject object = JSON.parseObject(accessInfoStr);
            String openId = object.get("openid").toString();
            String accessToken = object.get("access_token").toString();

            String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=";
            userInfoUrl = userInfoUrl + accessToken + "&openid=" + openId + "&lang=zh_CN";

            String userInfo = restTemplate.getForObject(userInfoUrl, String.class);

            LOGGER.info("getUserInfo:{}",userInfo);
            return responseOK(userInfo);
        } catch (Exception e) {
            LOGGER.error("getAuthCode error",e);
        }

        return responseError();
    }



}
