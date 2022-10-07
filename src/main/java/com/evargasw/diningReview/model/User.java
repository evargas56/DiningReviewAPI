package com.evargasw.diningReview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private Integer userLevel;

    public User() {}

    public User(User user) {
        this.username = user.getUsername();
        this.userLevel = user.getUserLevel();
    }

    public User(String username, Integer userLevel) {
        this.username = username;
        this.userLevel = userLevel;
    }
}
