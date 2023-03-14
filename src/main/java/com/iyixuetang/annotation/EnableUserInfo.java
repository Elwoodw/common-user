package com.iyixuetang.annotation;

import com.iyixuetang.configuration.UserInfoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 *
 * date: 2023/3/14 13:41 
 * author: wujincheng
 * version: 1.0 
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({UserInfoConfiguration.class})
public @interface EnableUserInfo {

}
