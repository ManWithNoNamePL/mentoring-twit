package com.tweet.core.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tweet")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tweet_id")
    private Long tweetId;

    @JoinColumn(name = "user_id", referencedColumnName = "username", nullable = false)
    private Long userId;

    @Column(name = "content", length = 140)
    private String content;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;
}
