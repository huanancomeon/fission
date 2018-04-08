package com.doc.xushi.controller;

import com.alibaba.fastjson.JSON;
import com.doc.xushi.entity.vo.ResponseInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by 5000 on 2018/4/1.
 */
public class BaseController {

    protected Long getUserId(String openUserID) {
        return 225079L;
    }

    protected ResponseEntity<String> responseOK(Object model) {

        ResponseInfo<Object> responseInfo = new ResponseInfo();
        responseInfo.setModel(model);
        return new ResponseEntity(JSON.toJSONString(responseInfo), HttpStatus.OK);
    }

    protected ResponseEntity<String> responseOK() {

        ResponseInfo<Object> responseInfo = new ResponseInfo();
        return new ResponseEntity(JSON.toJSONString(responseInfo), HttpStatus.OK);
    }

    protected ResponseEntity<String> responseError() {

        ResponseInfo<Object> responseInfo = new ResponseInfo();
        responseInfo.setCode(501);
        responseInfo.setMessage("服务异常");
        return new ResponseEntity(JSON.toJSONString(responseInfo), HttpStatus.OK);
    }

    protected ResponseEntity<String> responseError(String msg) {

        ResponseInfo<Object> responseInfo = new ResponseInfo();
        responseInfo.setCode(501);
        responseInfo.setMessage(msg);
        return new ResponseEntity(JSON.toJSONString(responseInfo), HttpStatus.OK);
    }

    protected ResponseEntity<String> responseParamError() {

        ResponseInfo<Object> responseInfo = new ResponseInfo();
        responseInfo.setCode(403);
        responseInfo.setMessage("参数异常");
        return new ResponseEntity(JSON.toJSONString(responseInfo), HttpStatus.OK);
    }
}
