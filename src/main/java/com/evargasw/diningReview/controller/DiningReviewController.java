package com.evargasw.diningReview.controller;

import com.evargasw.diningReview.model.*;
public class DiningReviewController {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Enrique's", "Glasgow", "Chinese", Boolean.TRUE, Boolean.FALSE, 2, 4.3, 3.7, 4.5);

        System.out.println(restaurant.toString());
    }
}
