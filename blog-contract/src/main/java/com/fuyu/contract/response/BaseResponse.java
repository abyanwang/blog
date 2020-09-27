package com.fuyu.contract.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse<T> {
    private int code;
    private boolean success;
    private T data;

    public static<T> BaseResponse<T> newSuccessResponse(T result) {
        return BaseResponse.<T>builder()
                .code(1000)
                .success(true)
                .data(result)
                .build();
    }

    public static<T> BaseResponse<T> newFailResponse() {
        return BaseResponse.<T>builder()
                .code(2000)
                .success(false)
                .build();
    }

    public static<T> BaseResponse<T> newFailResponse(T result) {
        return BaseResponse.<T>builder()
                .code(2000)
                .data(result)
                .success(false)
                .build();
    }
}
