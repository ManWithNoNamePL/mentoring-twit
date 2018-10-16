package com.tweet.core.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    private @Id String username;
    private String email;
    private String firstName;
    private String surname;

    @Enumerated(EnumType.STRING)
    @ManyToMany
    private List<UserRole> userRoles;

    @OneToMany(mappedBy = "user", targetEntity = Tweet.class)
    private Set<Tweet> tweets;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(Set<Tweet> tweets) {
        this.tweets = tweets;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
