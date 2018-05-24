package com.doc.xushi.controller;

import com.doc.xushi.utils.SHA1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.SHA;

import java.util.Arrays;

/**
 * Created by 5000 on 2018/5/24.
 */

@RestController
@RequestMapping("/token")
public class WXTockenController {


    @RequestMapping("/check")
    public String checkSignature(String echostr, String signature, String timestamp, String nonce) {
        String Token = "pc8y4m5Ne";
        String[] ArrTmp = {Token, timestamp, nonce};
        Arrays.sort(ArrTmp);
        String tmpStr = String.join("", ArrTmp);
        tmpStr = SHA1.encode(tmpStr);
        tmpStr = tmpStr.toLowerCase();
        if (tmpStr.equals(signature)) {
            return echostr;
        }
        return "error";
    }

}
