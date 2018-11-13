package com.tweet.core.service.impl;

import com.tweet.core.model.Tweet;
import com.tweet.core.model.User;
import com.tweet.core.service.TweetService;
import com.tweet.core.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class TweetServiceImplTest {

    private static final LocalDate NOW = LocalDate.now();

    @Autowired
    private TweetService tweetService;
    @Autowired
    private UserService userService;

    private User tweetOwner;

    @BeforeEach
    void setUpTweetOwnerUser() {
        User user = new User();
        user.setFirstName("Test F");
        user.setSurname("Test S");
        user.setUsername("test");
        user.setEmail("test@te.co");
        user.setPassword("pass12345");
        tweetOwner = userService.create(user);
    }

    @Test
    void getOne_existingTweet_returnTweet() {
        Long tweetId = createCorrectTweet("Hello, World! 1", NOW, tweetOwner.getId());

        Tweet tweet = new Tweet();
        tweet.setContent("Hello, World! 1");
        tweet.setCreatedDate(NOW);

        assertThat(tweetService.getById(tweetId))
                .isEqualToIgnoringGivenFields(tweet, "tweetId", "userId");
    }

    @Test
    void getAll_returnExistingTweets() {
        createCorrectTweet("Hello, World! 1", NOW, tweetOwner.getId());
        createCorrectTweet("Hello, World! 2", NOW, tweetOwner.getId());

        Tweet tweet1 = new Tweet();
        tweet1.setContent("Hello, World! 1");
        tweet1.setCreatedDate(NOW);

        Tweet tweet2 = new Tweet();
        tweet2.setContent("Hello, World! 2");
        tweet2.setCreatedDate(NOW);

        assertThat(tweetService.getAll())
                .usingElementComparatorIgnoringFields("tweetId", "userId")
                .containsExactly(tweet1, tweet2);
    }

    @Test
    void getUserByTweet_correctTweetId_returnUser() {
        Long tweetId = createCorrectTweet("Hello, World! 1", NOW, tweetOwner.getId());

        assertThat(tweetService.getUserIdByTweet(tweetId))
                .isEqualTo(tweetOwner.getId());
    }


    @Test
    void getAllUserTweets_correctUserId_returnAllTweets() {
        createCorrectTweet("Hello, World! 1", NOW, tweetOwner.getId());
        createCorrectTweet("Hello, World! 2", NOW, tweetOwner.getId());
        assertThat(tweetService.getAllUserTweets(tweetOwner.getId()))
                .hasSize(2);
    }

    private Long createCorrectTweet(String content, LocalDate date, Long userId) {
        Tweet tweet = new Tweet();
        tweet.setContent(content);
        tweet.setCreatedDate(date);
        tweet.setUserId(userId);

        return tweetService.create(tweet).getTweetId();
    }

}