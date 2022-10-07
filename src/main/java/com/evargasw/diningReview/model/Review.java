package com.evargasw.diningReview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    private ReviewStatus status;
}
