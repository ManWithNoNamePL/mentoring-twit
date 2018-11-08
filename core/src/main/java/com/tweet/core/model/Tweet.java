package com.tweet.core.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return Objects.equals(getTweetId(), tweet.getTweetId()) &&
                Objects.equals(getUserId(), tweet.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTweetId(), getUserId());
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "tweetId=" + tweetId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
