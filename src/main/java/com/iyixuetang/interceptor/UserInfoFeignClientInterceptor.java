package com.iyixuetang.interceptor;

import com.alibaba.fastjson.JSON;
import com.iyixuetang.constant.UserInfoConstant;
import com.iyixuetang.context.UserInfoContext;
import com.iyixuetang.entity.UserInfo;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *
 * date: 2023/3/14 11:31 
 * author: wujincheng
 * version: 1.0 
 */
@Slf4j
public class UserInfoFeignClientInterceptor  implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        UserInfo user= UserInfoContext.getUser();
        log.info("用户信息:"+ JSON.toJSONString(user));
        if(user!=null)
        {
          try
          {
              String userJson=JSON.toJSONString(user);
              requestTemplate.header(UserInfoConstant.Authorization,new String[]{URLEncoder.encode(userJson,"UTF-8")});
          }catch (UnsupportedEncodingException e)
          {
              log.error("用户信息错误",e);
          }
          finally {
              UserInfoContext.remove();
          }
        }

    }
}
