package com.tweet.core.error;

import org.springframework.http.HttpStatus;

import static java.lang.String.format;

public class UserNotFoundException extends TweetCommonException {

    public UserNotFoundException(String userId) {
        super(format(ErrorCode.USER_NOT_FOUND.getMsg(), userId));
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
