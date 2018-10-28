package com.tweet.core.service.impl;

import com.tweet.core.model.Tweet;
import com.tweet.core.service.TweetService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class TweetServiceImplTest {

    private static final LocalDate NOW = LocalDate.now();
    private static TweetService tweetService = new TweetServiceImpl();

    @BeforeAll
    private static void setUp() {
        createCorrectTweet("Hello, World! 1", NOW, 1L, 1L);
        createCorrectTweet("Hello, World! 2", NOW, 2L, 1L);
    }

    @Test
    void getOne_existingTweet_returnTweet() {
        Tweet tweet = new Tweet();
        tweet.setContent("Hello, World! 1");
        tweet.setCreatedDate(NOW);
        tweet.setTweetId(1L);
        tweet.setUserId(1L);

        assertThat(tweetService.getById(1L))
                .isEqualToComparingFieldByField(tweet);
    }

    @Test
    void getAll_returnExistingTweets() {
        Tweet tweet1 = new Tweet();
        tweet1.setContent("Hello, World! 1");
        tweet1.setCreatedDate(NOW);
        tweet1.setTweetId(1L);
        tweet1.setUserId(1L);

        Tweet tweet2 = new Tweet();
        tweet2.setContent("Hello, World! 2");
        tweet2.setCreatedDate(NOW);
        tweet2.setTweetId(2L);
        tweet2.setUserId(1L);

        assertThat(tweetService.getAll())
                .containsExactly(tweet1, tweet2);
    }

    @Test
    void getUserByTweet_correctTweetId_returnUser() {
        assertThat(tweetService.getUserByTweet(1L).getId())
                .isEqualTo(1L);
    }


    @Test
    void getAllUserTweets_correctUserId_returnAllTweets() {
        assertThat(tweetService.getAllUserTweets(1L))
                .hasSize(2)
                .isEqualTo(1L);
    }

    private static void createCorrectTweet(String content, LocalDate date, Long id, Long userId) {
        Tweet tweet = new Tweet();
        tweet.setContent(content);
        tweet.setCreatedDate(date);
        tweet.setTweetId(id);
        tweet.setUserId(userId);

        tweetService.create(tweet);
    }

}