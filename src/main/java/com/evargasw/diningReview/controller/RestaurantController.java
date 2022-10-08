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

    //Obtain a specific restaurant by id
    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable Long id) {
        var restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isPresent()) {
            return restaurantOptional.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    //Search for restaurants (PLURAL)
    //By name
    @GetMapping("/search")
    public Iterable<Restaurant> searchRestaurantsByName(@RequestParam String name) {
        Iterable<Restaurant> restaurants = restaurantRepository.findRestaurantsByName(name);

        if (!restaurants.iterator().hasNext()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return restaurants;
    }

    //By location
    @GetMapping("/search")
    public Iterable<Restaurant> searchRestaurantsByLocation(@RequestParam String location) {
        Iterable<Restaurant> restaurants = restaurantRepository.findRestaurantsByLocation(location);

        if (!restaurants.iterator().hasNext()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return restaurants;
    }

    //Update restaurant details by id (ADMIN)
    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        Restaurant updateRestaurant = restaurantRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        updateRestaurant.setName(restaurant.getName());
        updateRestaurant.setLocation(restaurant.getLocation());
        updateRestaurant.setCuisine(restaurant.getCuisine());
        updateRestaurant.setVegetarian(restaurant.getVegetarian());
        updateRestaurant.setVegan(restaurant.getVegan());
        updateRestaurant.setPriceRange(restaurant.getPriceRange());

        //SCORES ARE NOT UPDATED
        return restaurantRepository.save(updateRestaurant);
    }
}
