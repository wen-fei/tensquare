package com.tensquare.qa.client.impl;

import com.tensquare.qa.client.LabelClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

/**
 * @author : TenYun
 * @date : 2019-06-10 8:53
 * @description :
 **/
@Component
public class LabelClientImpl implements LabelClient {
    @Override
    public Result findById(String id) {
        return new Result(false, StatusCode.ERROR, "熔断器启动了");
    }
}
