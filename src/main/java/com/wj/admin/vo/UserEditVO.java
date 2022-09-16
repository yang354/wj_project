package com.wj.admin.vo;

import lombok.Data;

@Data
public class UserEditVO {

    private Long id;

    /**
     * 登录名称(用户名)
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;
}
