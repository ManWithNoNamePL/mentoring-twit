package com.tweet.core.service.impl;

import com.tweet.core.error.TweetNotFoundException;
import com.tweet.core.model.Tweet;
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
    public Tweet create(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public Tweet getById(Long tweetId) {
        return tweetRepository.findById(tweetId).orElseThrow(
                () -> new TweetNotFoundException(tweetId));
    }

    @Override
    public List<Tweet> getAll() {
        return tweetRepository.findAll();
    }

    @Override
    public void delete(Long tweetId) {

    }

    @Override
    public Long getUserIdByTweet(Long tweetId) {
        return tweetRepository.findById(tweetId).orElseThrow(
                () -> new TweetNotFoundException(tweetId))
                .getUserId();
    }

    @Override
    public List<Tweet> getAllUserTweets(Long userId) {
        return tweetRepository.findAllByUserId(userId);
    }
}
