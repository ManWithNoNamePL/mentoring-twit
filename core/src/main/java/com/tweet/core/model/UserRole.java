package com.tweet.core.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleId;

    @Enumerated(EnumType.STRING)
    private Name name;

    public enum Name {
        USER, ADMINISTRATOR
    }
}
