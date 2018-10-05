package com.tweet.core.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserId {

    @Id
    private String username;
    private String email;
    private String firstName;
    private String surename;

}
