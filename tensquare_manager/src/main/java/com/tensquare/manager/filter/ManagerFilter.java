package com.tensquare.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : TenYun
 * @date : 2019-06-10 13:39
 * @description :
 **/
public class ManagerFilter extends ZuulFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("Zuul过滤器");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        if (request.getMethod().equals("OPTIONS")) {
            return null;
        }
        String url = request.getRequestURI();
        if (url.indexOf("/admin/login") > 0) {
            System.out.println("登录界面" + url);
            return null;
        }
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            Claims claims = jwtUtil.parseJWT(token);
            if (claims != null) {
                if ("admin".equals(claims.get("roles"))) {
                    requestContext.addZuulRequestHeader("Authorization", authHeader);
                    System.out.println("token 验证通过， 添加了头信息" + authHeader);
                    return null;
                }
            }
        }

        // 终止运行，过滤请求，不对其进行路由
        requestContext.setSendZuulResponse(false);
        // http状态码，返回错误码
        requestContext.setResponseStatusCode(401);
        requestContext.setResponseBody("无权访问");
        requestContext.getResponse().setContentType("text/html;charset=UTF-8");
        return null;
    }
}
