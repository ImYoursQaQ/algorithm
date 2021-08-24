package com.lalalahub.virtualwallet.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author teohubo
 */
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Throwable.class)
    public BaseResponse<?> handlerException(Throwable throwable){
        return new BaseResponse<>(500,throwable.getMessage());
    }
}
