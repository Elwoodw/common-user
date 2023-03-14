package com.iyixuetang.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * date: 2023/3/14 11:21 
 * author: wujincheng
 * version: 1.0 
 */
@Data
public class UserInfo implements Serializable {
    private Integer id;
    private String username;
}
