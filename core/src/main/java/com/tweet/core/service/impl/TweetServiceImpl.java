package com.tweet.core.service.impl;

import com.tweet.core.model.Tweet;
import com.tweet.core.model.User;
import com.tweet.core.repository.TweetRepository;
import com.tweet.core.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetServiceImpl implements TweetService {

    @Autowired
    private TweetRepository tweetRepository;


    @Override
    public void create(Tweet tweet) {

    }

    @Override
    public User getById(Long tweetId) {
        return null;
    }

    @Override
    public List<Tweet> getAll() {
        return null;
    }

    @Override
    public void update(Tweet update) {

    }

    @Override
    public void delete(String tweetId) {

    }

    @Override
    public void getUserByTweet(String tweetId) {

    }

    @Override
    public void getTweetByUser(String username) {

    }

    @Override
    public void getAllUserTweets(String username) {

    }
}
