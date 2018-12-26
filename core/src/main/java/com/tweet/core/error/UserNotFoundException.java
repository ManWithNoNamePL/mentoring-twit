package com.tweet.core.error;

import org.springframework.http.HttpStatus;

import static java.lang.String.format;

public class UserNotFoundException extends CommonException {

    public UserNotFoundException(Long userId) {
        super(format(ErrorCode.USER_NOT_FOUND.getMsg(), userId));
    }

    public UserNotFoundException(String username) {
        super(format(ErrorCode.USER_NOT_FOUND.getMsg(), username));
    }

    @Override
    public ErrorCode reason() {
        return ErrorCode.USER_NOT_FOUND;
    }

    @Override
    public HttpStatus httpStatus() {
        return HttpStatus.valueOf(ErrorCode.USER_NOT_FOUND.getCode());
    }
}
