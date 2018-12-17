package com.tweet.core.error;


public enum ErrorCode {
    USER_BY_NAME_NOT_FOUND(404, "The user with name [%s] is not found"),
    USER_BY_ID_NOT_FOUND(404, "The user with id [%s] is not found"),
    TWEET_NOT_FOUND(404, "The tweet with id [%s] is not found"),
    GENERAL_ERROR(500, "Unexpected server behaviour");

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
