package com.tensquare.qa.client;

import com.tensquare.qa.client.impl.LabelClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : TenYun
 * @date : 2019-06-08 19:00
 * @description : @FeignClient注解用于指定从哪个服务中调用功能
 * 里面的名称与被调用的服务名保持一致，并且不能包含下划线。
 **/
@FeignClient(value = "tensquare-base", fallback = LabelClientImpl.class)
public interface LabelClient {

    /**
     *
     * \@RequestMapping注解用于对被调用的微服务进行地址映射
     * \@PathVariable注解一定要指定参数名称，否则出错
     * @param id
     * @return
     */
    @RequestMapping(value = "/label/{id}", method = RequestMethod.GET)
    Result findById(@PathVariable("id") String id);
}
