package com.lalalahubo.virtualWallet.controller;

import lombok.Getter;

/**
 * @author teohubo
 */
@Getter
public class BaseResponse<T> {

    private Integer errno;

    private Boolean status;

    private T data;

    private String message;

    public BaseResponse(Integer errno, String message) {
        this.errno = errno;
        this.message = message;
        this.status = Boolean.TRUE;
    }

    public BaseResponse(T data) {
        this.data = data;
        this.errno = 0;
        this.status = Boolean.TRUE;
    }

    public static BaseResponse<?> buildSuccess(){
        return new BaseResponse<Object>("ok");
    }
}
