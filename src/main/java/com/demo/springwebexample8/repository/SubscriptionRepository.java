package com.demo.springwebexample8.repository;

import com.demo.springwebexample8.model.Friend;
import com.demo.springwebexample8.model.Subscription;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SubscriptionRepository extends ReactiveCrudRepository<Subscription, Integer> {

}
