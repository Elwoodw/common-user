package com.iyixuetang.context;

import com.iyixuetang.entity.UserInfo;

/**
 *
 * date: 2023/3/14 11:20 
 * author: wujincheng
 * version: 1.0 
 */
public class UserInfoContext {
    private static ThreadLocal<UserInfo>userInfo=new ThreadLocal<>();

    public static UserInfo getUser()
    {
        return userInfo.get();
    }

    public  static void setUser(UserInfo user)
    {
        userInfo.set(user);
    }

    public  static  void remove()
    {
        userInfo.remove();
    }




}
