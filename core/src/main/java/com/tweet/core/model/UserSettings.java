package com.tweet.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore // FIXME cycling dependency
    @OneToOne
    @MapsId
    @JoinColumn(name = "settings_id")
    private User userId;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "timezone")
    private TimeZone timeZone = TimeZone.getDefault();

    @Column(name = "language")
    private String language;

}
