package com.doc.xushi.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by 5000 on 2018/4/24.
 */
@Aspect
@Component
public class ValidateAspect {

    @Before(value = "execution(* *.*(..))&&@annotation(com.doc.xushi.annotation.Auth)")
    public void validate() {
        System.err.print("has validate");
    }
}
