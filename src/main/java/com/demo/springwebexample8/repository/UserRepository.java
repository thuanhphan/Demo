package com.demo.springwebexample8.repository;

import com.demo.springwebexample8.model.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {

    @Query("SELECT email\n" +
            "FROM public.friend  JOIN public.user ON public.friend.person1 = \"user\".email\n" +
            "WHERE person2 = :email\n" +
            "UNION\n" +
            "SELECT person2\n" +
            "FROM public.friend\n" +
            "WHERE person1 = :email")
    Flux<User> findAllFriendsByEmail(@Param("email") String email);

    @Query("SELECT email \n" +
            "FROM\n" +
            "    (SELECT person1\n" +
            "     FROM friend\n" +
            "     WHERE person2 = :email1\n" +
            "     UNION\n" +
            "     SELECT person2\n" +
            "     FROM friend\n" +
            "     WHERE person1 = :email1) as list1\n" +
            "    INNER JOIN\n" +
            "    (SELECT person1\n" +
            "     FROM friend\n" +
            "     WHERE person2 = :email2\n" +
            "     UNION\n" +
            "     SELECT person2\n" +
            "     FROM friend\n" +
            "     WHERE person1 = :email2 ) as list2\n" +
            "    ON list1.person1 = list2.person1\n" +
            "INNER JOIN public.user u ON u.email = list1.person1")
    Flux<User> findCommonFriendsByEmail(@Param("email1") String email1, @Param("email2") String email2);

    @Query("SELECT email  \n" +
            "FROM\n" +
            "      (SELECT person1 FROM friend as person\n" +
            "      WHERE person2 = :email\n" +
            "      UNION\n" +
            "      SELECT person2 FROM friend as person\n" +
            "      WHERE person1 = :email) as list1\n" +
            "JOIN public.user ON email = list1.person1\n" +
            "WHERE list1.person1 NOT IN\n" +
            "      (SELECT blockee FROM block\n" +
            "      WHERE blocker = :email)\n" +
            "AND list1.person1 NOT IN (SELECT blocker FROM block WHERE blockee = :email)\n" +
            "      AND list1.person1 IN\n" +
            "      (SELECT requester FROM subscription\n" +
            "      WHERE target = :email)")
    Flux<User> findReceiverByEmail(@Param("email") String email);

}
