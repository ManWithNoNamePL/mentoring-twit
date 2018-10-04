package com.tweet.core.model;

import javax.persistence.Entity;

@Entity
public class Tweet {

    private String username;
    private String content;
    private Long date;
}
