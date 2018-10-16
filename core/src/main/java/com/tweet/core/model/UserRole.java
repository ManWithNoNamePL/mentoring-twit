package com.tweet.core.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRole {

    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
