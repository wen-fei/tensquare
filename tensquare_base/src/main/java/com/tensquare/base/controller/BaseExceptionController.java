package com.tensquare.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : TenYun
 * @date : 2019-06-04 16:47
 * @description : base exception controller class
 **/

@RestController
public class BaseExceptionController {

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e) {
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
