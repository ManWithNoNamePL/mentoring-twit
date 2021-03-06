package com.tweet.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    // TODO mpoborowski: apparently there is bug in new hibernate that wont allow for data.sql and AUTO generation :/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @NaturalId
    private String isbn;

    @NotEmpty(message = "{NotEmpty.User.username}")
    @Column(name = "username", nullable = false)
    private String username;

    @Length(min = 8, max = 31, message = "{Length.User.password}")
    @Column(name = "password", nullable = false)
    private String password;

    @Email
    @NotEmpty(message = "{NotEmpty.User.email}")
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
    private UserSettings userSettings;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "followers_mapping",
            joinColumns = {@JoinColumn(name = "follower_id")},
            inverseJoinColumns = {@JoinColumn(name = "followed_id")})
    private Set<User> following;

    @JsonIgnore
    @ManyToMany(mappedBy = "following")
    private Set<User> followers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getIsbn(), user.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbn());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", active=" + getActive() +
                ", userRoles=" + getUserRoles() +
                ", tweets=" + getTweets() +
                ", userSettings=" + this.getUserSettings() +
                '}';
    }
}
