package com.evargasw.diningReview.controller;

import com.evargasw.diningReview.model.Restaurant;
import com.evargasw.diningReview.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    //Set up repository and constructor
    private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    //Obtain all restaurants in db
    @GetMapping
    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    //Obtain a specific restaurant by id
    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable Long id) {
        var restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isPresent()) {
            return restaurantOptional.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    //Check if restaurant already exists in db and if it is a valid restaurant
    private void checkRestaurant(Restaurant restaurant) {
        if (restaurant.getName().isEmpty() || restaurant.getLocation().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Optional<Restaurant> existingRestaurant = restaurantRepository.findRestaurantByNameAndLocation(restaurant.getName(), restaurant.getLocation());
        if (existingRestaurant.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    //Create new restaurant
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        checkRestaurant(restaurant);

        return restaurantRepository.save(restaurant);
    }

    //Search for restaurants
    //By location
    @GetMapping("/search")
    public Iterable<Restaurant> searchRestaurantsByLocation(@RequestParam String location) {
        Iterable<Restaurant> restaurants = restaurantRepository.findRestaurantsByLocation(location);

        if (!restaurants.iterator().hasNext()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return restaurants;
    }

}
