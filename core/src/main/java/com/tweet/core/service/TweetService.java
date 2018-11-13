package com.tweet.core.service;

import com.tweet.core.model.Tweet;
import com.tweet.core.model.User;

import java.util.List;

public interface TweetService {

    Tweet create(Tweet tweet);

    Tweet getById(Long tweetId);

    List<Tweet> getAll();

    void delete(Long tweetId);

    Long getUserIdByTweet(Long tweetId);

    List<Tweet> getAllUserTweets(Long userId);

}
