package com.iyixuetang.filter;

import com.alibaba.fastjson.JSON;
import com.iyixuetang.constant.UserInfoConstant;
import com.iyixuetang.context.UserInfoContext;
import com.iyixuetang.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 *
 * date: 2023/3/14 13:16 
 * author: wujincheng
 * version: 1.0 
 */
@Slf4j
public class UserInfoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
 initUserInfo((HttpServletRequest) servletRequest);
 filterChain.doFilter(servletRequest, servletResponse);

    }

    public void initUserInfo(HttpServletRequest request)
    {
        String userJson=request.getHeader(UserInfoConstant.Authorization);
        log.info("接收用户信息："+userJson);
        if(StringUtils.isNotBlank(userJson))
        {
            try
            {
                userJson= URLDecoder.decode(userJson,"UTF-8");
                UserInfo userInfo= JSON.parseObject(userJson,UserInfo.class);
                UserInfoContext.setUser(userInfo);

            }catch (UnsupportedEncodingException e)
            {
                log.error("初始化用户信息失败",e);
            }
        }
    }
}
