package com.demo.springwebexample8.controller;

import com.demo.springwebexample8.dto.CreateFriendSuccessResponseDto;
import com.demo.springwebexample8.dto.FriendRequestDto;
import com.demo.springwebexample8.dto.RetrieveFriendListSuccessResponseDto;
import com.demo.springwebexample8.model.User;
import com.demo.springwebexample8.service.FriendServiceApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api")
public class FriendController {

    @Autowired
    private FriendServiceApplication friendServiceApplication;

    @PostMapping(value = "/friendRequest")
    public Mono<CreateFriendSuccessResponseDto> create(@RequestBody FriendRequestDto dto) {
        friendServiceApplication.createFriendship(dto);
        return Mono.just(new CreateFriendSuccessResponseDto());
    }

    @PostMapping(value = "/getFriends")
    public Mono<RetrieveFriendListSuccessResponseDto> create(@RequestBody User user) {
        Flux<String> stringFlux = friendServiceApplication.getFriendList(user.getEmail());

        return Mono.just(new RetrieveFriendListSuccessResponseDto());
    }
}