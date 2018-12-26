package com.tweet.core.model;

import lombok.Data;

import javax.persistence.*;
import java.util.TimeZone;

@Data
@Entity
@Table(name = "user_settings")
public class UserSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "settings_id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "timezone")
    private TimeZone timeZone = TimeZone.getDefault();

    @Column(name = "language")
    private String language;

}
