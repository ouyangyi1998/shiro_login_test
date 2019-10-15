package com.jerry.shiro_test1.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j

public class myExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public String ErrorHandler(AbstractMethodError e)
    {
        log.error("没有通过效验",e);
        return "没有通过效验";
    }
}
