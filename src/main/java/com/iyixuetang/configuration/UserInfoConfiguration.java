package com.iyixuetang.configuration;

import com.iyixuetang.filter.UserInfoFilter;
import com.iyixuetang.interceptor.UserInfoFeignClientInterceptor;
import org.springframework.context.annotation.Bean;

/**
 *
 * date: 2023/3/14 13:33 
 * author: wujincheng
 * version: 1.0 
 */
public class UserInfoConfiguration {

    @Bean
    public UserInfoFeignClientInterceptor userInfoFeignClientInterceptor()
    {
        return new UserInfoFeignClientInterceptor();
    }

    @Bean
    public UserInfoFilter userInfoFilter()
    {
        return new UserInfoFilter();
    }
}
