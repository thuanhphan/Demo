package com.demo.springwebexample8.service;

import com.demo.springwebexample8.dto.FriendRequestDto;
import com.demo.springwebexample8.model.Friend;
import com.demo.springwebexample8.model.User;
import org.springframework.data.r2dbc.repository.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FriendServiceApplication {
    Mono<Friend> createFriendship(FriendRequestDto dto);

    Flux<String> getFriendList(String email);

}
