package com.evargasw.diningReview.repository;

import com.evargasw.diningReview.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>{
    List<User> getAllByUserLevel(Integer level);
    Optional<User> findByDisplayName(String displayName);
    int countByUserLevel(Integer level);
}
