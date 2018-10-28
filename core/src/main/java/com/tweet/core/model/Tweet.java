package com.tweet.core.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tweetId;

    @JoinColumn(name = "user", referencedColumnName = "username", nullable = false)
    private Long userId;
    private String content;
    private LocalDate createdDate;
}
