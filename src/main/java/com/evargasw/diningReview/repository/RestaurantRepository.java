package com.evargasw.diningReview.repository;

import com.evargasw.diningReview.model.Restaurant;
import com.evargasw.diningReview.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    Optional<Restaurant> findRestaurantByName(String name);
    Optional<Restaurant> findRestaurantByNameAndLocation(String name, String location);
    Restaurant getRestaurantById(Long id);
    List<Restaurant> findRestaurantsByScoreGreaterThan(Double minScore);
    List<Restaurant> findRestaurantsByLocation(String location);
    List<Restaurant> findRestaurantsByPriceRange(Integer priceRange);
}
