package com.tweet.core.controller;

import com.tweet.core.model.Tweet;
import com.tweet.core.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @PostMapping
    public ResponseEntity createTweet(Tweet tweet) {
        tweetService.create(tweet);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{tweetId}")
    public ResponseEntity getTweetById(@PathVariable Long tweetId) {
        return ResponseEntity.ok(tweetService.getById(tweetId));
    }

    @GetMapping(value = "/{tweetId}/user")
    public ResponseEntity getUserByTweet(@PathVariable Long tweetId) {
        return ResponseEntity.ok(tweetService.getUserByTweet(tweetId));
    }

    @GetMapping(value = "/{username}/all")
    public ResponseEntity getTweetsByUser(@PathVariable String username) {
        return ResponseEntity.ok(tweetService.getAllUserTweets(username));
    }

    @DeleteMapping(value = "/{tweetId}")
    public ResponseEntity deleteTweet(@PathVariable Long tweetId) {
        tweetService.delete(tweetId);
        return ResponseEntity.ok().build();
    }

}
