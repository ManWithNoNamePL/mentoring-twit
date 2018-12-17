package com.tweet.core.error;

import org.springframework.http.HttpStatus;

import static java.lang.String.format;

public class TweetNotFoundException extends CommonException {

    public TweetNotFoundException(Long tweetId) {
        super(format(ErrorCode.TWEET_NOT_FOUND.getMsg(), tweetId));
    }

    @Override
    public ErrorCode reason() {
        return ErrorCode.TWEET_NOT_FOUND;
    }

    @Override
    public HttpStatus httpStatus() {
        return HttpStatus.valueOf(ErrorCode.TWEET_NOT_FOUND.getCode());
    }
}
