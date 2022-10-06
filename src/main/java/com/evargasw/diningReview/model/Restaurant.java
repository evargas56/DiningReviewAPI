package com.evargasw.diningReview.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String location;

    private String cuisine;

    private Boolean vegetarian;

    private Boolean vegan;

    private Integer priceRange;

    private Double score;
}
