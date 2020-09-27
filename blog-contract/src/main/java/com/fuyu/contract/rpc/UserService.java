package com.fuyu.contract.rpc;

import com.fuyu.contract.request.UserLoginRequest;
import com.fuyu.contract.response.BaseResponse;
import com.fuyu.contract.response.UserLoginResponse;

public interface UserService {
    BaseResponse<UserLoginResponse> userLogin(UserLoginRequest request);
}
