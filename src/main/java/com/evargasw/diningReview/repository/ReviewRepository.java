package com.evargasw.diningReview.repository;

import com.evargasw.diningReview.model.Review;
import com.evargasw.diningReview.model.ReviewStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> getReviewsByStatus(ReviewStatus status);
    List<Review> findReviewsByStatusAndRestaurantId(ReviewStatus status, Long restaurantId);
}
