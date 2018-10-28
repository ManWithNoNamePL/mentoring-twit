package com.tweet.core.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String surname;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_mapping",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserRole> userRoles;

    @OneToMany(mappedBy = "user", targetEntity = Tweet.class)
    private Set<Tweet> tweets;
}
