package com.tensquare.web.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : TenYun
 * @date : 2019-06-10 9:48
 * @description :
 **/
@Component
public class WebFilter extends ZuulFilter {
    /**
     * 返回一个字符串代表过滤器的类型，主要是四种：
     * 1. pre：在请求被路由之前调用
     * 2. route：在路由请求时候被调用
     * 3. post：在route和error过滤器之后被调用
     * 4. error：处理请求时发生错误时调用
     */
    @Override
    public String filterType() {
        // 前置过滤器
        return "pre";
    }

    /**
     *     通过int值来定义过滤器的执行顺序
      */
    @Override
    public int filterOrder() {
        // 优先级为0，数字越大，优先级越低
        return 0;
    }

    /**
     * 过滤器的开关
     */
    @Override
    public boolean shouldFilter() {
        // 是否执行该过滤器，此处为true需要过滤
        return false;
    }

    /**
     * 过滤器的具体逻辑
     * 接收header，转发给微服务
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("zuul过滤器...");
        // 向header中添加鉴权令牌
        RequestContext requestContext = RequestContext.getCurrentContext();
        // 获取header
        HttpServletRequest request = requestContext.getRequest();
        String authorization =  request.getHeader("Authorization");
        if (authorization != null) {
            requestContext.addZuulRequestHeader("Authorization", authorization);
        }
        return null;
    }
}
