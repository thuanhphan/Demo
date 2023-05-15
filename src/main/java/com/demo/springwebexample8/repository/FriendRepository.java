package com.demo.springwebexample8.repository;

import com.demo.springwebexample8.model.Friend;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends ReactiveCrudRepository<Friend, Integer> {
}
