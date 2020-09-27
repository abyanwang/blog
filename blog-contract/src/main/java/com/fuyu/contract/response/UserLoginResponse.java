package com.fuyu.contract.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginResponse implements Serializable {
    /**
     * 登陆是否成功.
     */
    private Boolean success;
}
