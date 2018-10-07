package com.tweet.core.service;

import com.tweet.core.model.Tweet;
import com.tweet.core.model.User;

import java.util.List;

public interface TweetService {

    void create(Tweet tweet);

    User getById(Long tweetId);

    List<Tweet> getAll();

    void update(Tweet update);

    void delete(String tweetId);

    void getUserByTweet(String tweetId);

    void getTweetByUser(String username);

    void getAllUserTweets(String username);

}
