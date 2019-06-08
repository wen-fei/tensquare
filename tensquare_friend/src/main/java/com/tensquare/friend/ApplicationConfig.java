package com.tensquare.friend;

import com.tensquare.friend.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * @author : TenYun
 * @date : 2019-06-08 20:40
 * @description :
 **/
@Configuration
public class ApplicationConfig {

    @Autowired
    private JwtFilter jwtFilter;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtFilter)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/login");
    }
}
