package com.tweet.core.error;

import org.springframework.http.HttpStatus;

public class TweetCommonException extends Exception {
    public TweetCommonException(String message) {
        super(message);
    }

    public ErrorCode reason() {
        return ErrorCode.GENERAL_ERROR;
    }

    public HttpStatus httpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
