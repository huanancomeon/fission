package com.doc.xushi.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 5000 on 2018/4/30.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/wx")
    public ResponseEntity<String> weCartLogin() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("auth_token", "asdfgh");
        headers.set("Other-Header", "othervalue");
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject parm = new JSONObject();
        parm.put("parm", "1234");

        HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(parm, headers);
//        restTemplate.execute("http://localhost:8080/headerApi", HttpMethod.POST, entity, String.class);
        return null;
    }

}
