package com.tweet.core.model;

import lombok.Data;

import javax.persistence.*;
import java.util.TimeZone;

@Data
@Entity
@Table(name = "user_settings")
public class UserSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "settings_id", nullable = false)
    private Long id;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private Long userId;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "timezone")
    private TimeZone timeZone = TimeZone.getDefault();

    @Column(name = "language")
    private String language;

}
