package com.tweet.core.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Length(min = 8)
    @Column(name = "password", nullable = false)
    private String password;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "active")
    private Integer active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_mapping", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserRole> userRoles;

    @OneToMany(mappedBy = "userId")
    private Set<Tweet> tweets;

    @OneToOne(mappedBy = "userId")
    private Settings settings;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "followers_mapping",
            joinColumns = {@JoinColumn(name = "follower_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "followed_id", referencedColumnName = "user_id")})
    private Set<User> following;

    @ManyToMany(mappedBy = "following") // TODO Infinite recursion (StackOverflowError) (through reference chain: com.tweet.core.model.User[\"following\"])
    private Set<User> followers;
}
