package com.tweet.core.model;

import lombok.Data;

import javax.persistence.*;
import java.util.TimeZone;

@Data
@Entity
@Table(name = "settings")
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "setting_id", nullable = false)
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
