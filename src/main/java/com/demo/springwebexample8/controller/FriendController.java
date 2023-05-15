package com.demo.springwebexample8.controller;

import com.demo.springwebexample8.dto.*;
import com.demo.springwebexample8.model.User;
import com.demo.springwebexample8.service.FriendServiceApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class FriendController {

    @Autowired
    private FriendServiceApplication friendServiceApplication;

    @PostMapping(value = "/makeFriends")
    public Mono<ApiSuccessResponseDto> create(@Valid @RequestBody FriendRequestDto dto) {
        return friendServiceApplication.makeFriends(dto);
    }

    @PostMapping(value = "/getFriends")
    public Mono<RetrieveFriendListSuccessResponseDto> getFriendList(@Valid @RequestBody User user) {
        return friendServiceApplication.getFriendList(user.getEmail());
    }

    @PostMapping(value = "/getCommonFriends")
    public Mono<RetrieveFriendListSuccessResponseDto> getCommonFriends(@Valid @RequestBody FriendRequestDto dto) {
        return friendServiceApplication.getCommonFriends(dto);
    }

    @PostMapping(value = "/subscribe")
    public Mono<ApiSuccessResponseDto> subscribe(@Valid @RequestBody RequestDto dto) {
        return friendServiceApplication.subscribe(dto);
    }

    @PostMapping(value = "/block")
    public Mono<ApiSuccessResponseDto> block(@Valid @RequestBody RequestDto dto) {
        return friendServiceApplication.block(dto);
    }

    @PostMapping(value = "/getEmailReceivers")
    public Mono<ReceiveUpdateSuccessResponseDto> retrieveEmails(@Valid @RequestBody ReceiveUpdateRequestDto dto) {
        return friendServiceApplication.receiveUpdates(dto);
    }

    @GetMapping(value = "/testing")
    public String home() {
        return "Hello World!";
    }
}