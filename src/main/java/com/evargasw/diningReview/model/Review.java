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
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private Double atmScore;

    private Double foodScore;

    private Double servScore;

    private Double score;

    private String comment;

    public Review() {}

    public Review(Review review) {
        this.username = review.getUsername();
        this.atmScore = review.getAtmScore();
        this.foodScore = review.getFoodScore();
        this.servScore = review.getServScore();
        this.score = (review.getAtmScore() + review.getFoodScore() + review.getServScore()) / 3;
        this.comment = review.getComment();
    }

    public Review(String username, Double atmScore, Double foodScore, Double servScore, String comment) {
        this.username = username;
        this.atmScore = atmScore;
        this.foodScore = foodScore;
        this.servScore = servScore;
        this.score = (atmScore + foodScore + servScore) / 3;
        this.comment = comment;
    }

}
