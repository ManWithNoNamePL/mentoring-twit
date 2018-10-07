package com.tweet.core.repository;

import com.tweet.core.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
