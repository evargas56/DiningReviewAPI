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

    public Restaurant() {}

    public Restaurant(Restaurant restaurant) {
        this.name = restaurant.getName();
        this.location = restaurant.getLocation();
        this.cuisine = restaurant.getCuisine();
        this.vegetarian = restaurant.getVegetarian();
        this.vegan = restaurant.getVegan();
        this.priceRange = restaurant.getPriceRange();
        this.atmScore = restaurant.getAtmScore();
        this.foodScore = restaurant.getFoodScore();
        this.servScore = restaurant.getServScore();
        this.score = (restaurant.getAtmScore() + restaurant.getFoodScore() + restaurant.getServScore()) / 3;
    }

    public Restaurant(String name, String location, String cuisine, Boolean vegetarian, Boolean vegan, Integer priceRange, Double atmScore, Double foodScore, Double servScore) {
        this.name = name;
        this.location = location;
        this.cuisine = cuisine;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.priceRange = priceRange;
        this.atmScore = atmScore;
        this.foodScore = foodScore;
        this.servScore = servScore;
        this.score = (atmScore + foodScore + servScore) / 3;
    }
}
