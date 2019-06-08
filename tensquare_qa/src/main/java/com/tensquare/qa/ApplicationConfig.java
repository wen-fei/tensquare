package com.tensquare.qa;

import com.tensquare.qa.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * @author : TenYun
 * @date : 2019-06-08 15:42
 * @description :
 **/
@Configuration
public class ApplicationConfig {

    @Autowired
    private JwtFilter jwtFilter;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtFilter)
                .addPathPatterns("/reply/**")
                .excludePathPatterns("/**/login**");
    }
}
