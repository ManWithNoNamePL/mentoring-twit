package com.tweet.core.error;


public enum ErrorCode {
    USER_NOT_FOUND(404, "The user with name [%s] is not found"),
    TWEET_NOT_FOUND(404, "The tweet with id [%s] is not found"),
    GENERAL_ERROR(500, "Happened something wrong");

    private final int code;
    private final String msg;
    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
