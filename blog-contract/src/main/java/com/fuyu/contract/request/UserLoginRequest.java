package com.fuyu.contract.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginRequest implements Serializable {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
}
