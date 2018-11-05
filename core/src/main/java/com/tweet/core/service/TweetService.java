package com.tweet.core.service;

import com.tweet.core.model.Tweet;
import com.tweet.core.model.User;

import java.util.List;

public interface TweetService {

    void create(Tweet tweet);

    User getById(Long tweetId);

    List<Tweet> getAll();

    void delete(Long tweetId);

    User getUserByTweet(Long tweetId);

    List<Tweet> getAllUserTweets(Long userId);

}
