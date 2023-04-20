package com.demo.springwebexample8.repository;

import com.demo.springwebexample8.model.Friend;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface FriendRepository extends ReactiveCrudRepository<Friend, Integer> {
    @Query("SELECT person1 as person\n" +
            "FROM public.friend \n" +
            "WHERE person2 = :email\n" +
            "UNION \n" +
            "SELECT person2 as person\n" +
            "FROM public.friend\n" +
            "WHERE person1 = :email")
    Flux<String> findFriendListByEmail(String email);
}
