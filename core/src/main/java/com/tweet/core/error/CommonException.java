package com.tweet.core.error;

import org.springframework.http.HttpStatus;

public abstract class CommonException extends RuntimeException {
    CommonException(String message) {
        super(message);
    }

    public abstract ErrorCode reason();

    public abstract HttpStatus httpStatus();

}
