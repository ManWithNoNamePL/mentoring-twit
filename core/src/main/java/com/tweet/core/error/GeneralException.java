package com.tweet.core.error;

import org.springframework.http.HttpStatus;

public class GeneralException extends CommonException {

    public GeneralException() {
        super(ErrorCode.GENERAL_ERROR.getMsg());
    }

    @Override
    public ErrorCode reason() {
        return ErrorCode.GENERAL_ERROR;
    }

    @Override
    public HttpStatus httpStatus() {
        return HttpStatus.valueOf(ErrorCode.GENERAL_ERROR.getCode());
    }
}
