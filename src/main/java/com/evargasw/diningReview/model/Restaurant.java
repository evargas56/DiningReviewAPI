package com.evargasw.diningReview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    public String name;

    private String location;
    private String cuisine;
    private Boolean vegetarian;
    private Boolean vegan;
    private Integer priceRange;

    private Double atmScore;
    private Double foodScore;
    private Double servScore;
    private Double score;
}
